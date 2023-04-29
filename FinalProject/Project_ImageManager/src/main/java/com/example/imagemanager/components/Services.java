package com.example.imagemanager.components;
import com.drew.imaging.ImageProcessingException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Services for implementing adding, deleting, downloading functions defined in API
public class Services implements ImageAPI {
    private List<Image> imageList;

    public Services() {
        imageList = new ArrayList<>();
    }

    public Integer getNumberOfImages() {
        return imageList.size();
    }

    public void addSingleImage(Image image) {
        this.imageList.add(image);
    }

    /*
    return new added images
    imageList is all active images
     */
    public List<Image> addMultipleImages(List<File> files) throws ImageProcessingException, IOException {
        List<Image> newList = new ArrayList<>();
        if(files != null){
            for (File file : files) {
                Image image = new Image(file);
                addSingleImage(image);
                newList.add(image);
            }
        }
        return newList;
    }

    public void deleteSingleImage(Integer targetId) {
        imageList.removeIf(value -> value.getId() == targetId);
    }

    public void deleteAllImages() {
        if (imageList.isEmpty()) {
            imageIsEmptyPopup("No images to delete. Please add images first.");
            return;
        }
        imageList.clear();
    }

    public void downloadSingleImage(Integer targetId) throws IOException {
        Image targetImage = null;

        for (Image image : imageList) {
            if (image.getId() == targetId) {
                targetImage = image;
            }
        }

        if (targetImage != null) {
            // Resize
            targetImage.changeSize();
            // Apply filter
            targetImage.applyFilter();

            File writeFile = Loader.getSaveFile(targetImage.getOutputFormat());
            if (writeFile != null) {
                ImageIO.write(targetImage.getOutputBufferedImage(), targetImage.getOutputFormat(), writeFile);
            }
        } else {
            System.out.println("no target");
        }
    }

//    downloadAllImage method will return err message if no image has been added
    public void downloadAllImages() throws IOException {
        if (imageList.isEmpty()) {
            imageIsEmptyPopup("No images to download. Please add images first.");
            return;
        }

        File writeZipFile = Loader.getSaveFile("ZIP");
        if (writeZipFile != null) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(writeZipFile));
            FileOutputStream fos = new FileOutputStream(writeZipFile);

            for (Image image : imageList) {
                image.changeSize();
                image.applyFilter();
                File outputImageFile = new File(image.getZipName());
                ImageIO.write(image.getOutputBufferedImage(), image.getOutputFormat(), outputImageFile);

                FileInputStream fis = new FileInputStream(outputImageFile);
                ZipEntry zipEntry = new ZipEntry(outputImageFile.getName());
                zipOutputStream.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOutputStream.write(bytes, 0, length);
                }
                fis.close();
                outputImageFile.delete();

            }
            zipOutputStream.close();
            fos.close();
        }
    }

//    Setting up err message popup
    private void imageIsEmptyPopup(String errorMessage) {
        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setBackground(Color.WHITE);


        JLabel label = new JLabel(errorMessage);
        label.setFont(new Font("Arial",Font.BOLD, 14));
        label.setForeground(Color.decode("#1a73e8"));

        dialog.add(label);

        JOptionPane.showMessageDialog(dialog, label, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

