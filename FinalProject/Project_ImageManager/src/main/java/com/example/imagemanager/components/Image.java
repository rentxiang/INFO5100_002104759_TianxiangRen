package com.example.imagemanager.components;
// import image.io and drew package for image managing functions
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Class Image extends class media, serves as image object, holding methods for functionality
public class Image extends Media {
    private final javafx.scene.image.Image fxImage;
    private BufferedImage inputBufferedImage;
    private String imageName;
    private String model;
    private String imageSize;
    private String longitude;
    private String latitude;
    private BufferedImage outputBufferedImage;
    private int inputWidth;
    private int outputWidth;
    private int inputHeight;
    private int outputHeight;
    private String inputFormat;
    private String outputFormat;
    private String selectedFilter;

    // read image file by implementing ImageIO
    public Image(File file) throws ImageProcessingException, IOException {
        super(file);
        readMetadata(file);
        inputBufferedImage = ImageIO.read(file);
        fxImage = SwingFXUtils.toFXImage(inputBufferedImage, null);
    }

//     Read method for reading file's attribute such as name, size, GPS Longitude and Height, etc
    private void readMetadata(File file) throws ImageProcessingException, IOException {
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();
                String tagValue = tag.getDescription();
                switch (tagName) {
//                    catch attributes if exists
                    case "File Name" -> imageName = tagValue;
                    case "Detected File Type Name" -> inputFormat = tagValue;
                    case "File Size" -> imageSize = tagValue;
                    case "Model" -> model = tagValue;
                    case "GPS Longitude" -> longitude = tagValue;
                    case "GPS Latitude" -> latitude = tagValue;
                    case "Image Height" -> inputHeight = parseTagValue(tagValue);
                    case "Image Width" -> inputWidth = parseTagValue(tagValue);
                    default -> {
                    }
                }
            }
        }
    }

//    Parse the pixels info
    private int parseTagValue(String tagValue) {
        if (tagValue.contains("pixels")) {
            return Integer.parseInt(tagValue.split(" ")[0]);
        } else {
            return Integer.parseInt(tagValue);
        }
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getModel() {
        return model;
    }

    public javafx.scene.image.Image getFXImage() {
        return fxImage;
    }

    // override methods for returning infos
    @Override
    public String getName() {
        return imageName;
    }

    public String getImageSize() {
        return imageSize;
    }

    public String getInputWidth() {
        return Integer.toString(inputWidth);
    }

    public String getInputHeight() {
        return Integer.toString(inputHeight);
    }

    public String getInputFormat() {
        return inputFormat;
    }
    public String getOutputFormat() {
        return outputFormat;
    }
    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public void setOutputSizeOriginal() {
        outputHeight = inputHeight;
        outputWidth = inputWidth;
    }

//    method for setting the output size
    public void setOutputSize(String selectedSize) {
        switch (selectedSize) {
            case ("100px * 100px") -> {
                this.outputWidth = 100;
                this.outputHeight = 100;
            }
            case ("320px * 180px") -> {
                this.outputWidth = 320;
                this.outputHeight = 180;
            }
            case ("360px * 360px") -> {
                this.outputWidth = 360;
                this.outputHeight = 360;
            }
            case ("820px * 312px") -> {
                this.outputWidth = 820;
                this.outputHeight = 312;
            }
            default -> {
                setOutputSizeOriginal();
            }
        }
    }

//    method for changing image size
    public void changeSize() throws IOException {
        if(inputBufferedImage == null) {
            throw new IOException("Input image is null");
        }
        outputBufferedImage = new BufferedImage(outputWidth, outputHeight, inputBufferedImage.getType());
        Graphics2D g2d = outputBufferedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(inputBufferedImage, 0, 0, outputWidth, outputHeight, null);
        g2d.dispose();

        updateInputBufferedImage();
    }

    public BufferedImage getOutputBufferedImage() {
        return outputBufferedImage;
    }

    public void updateInputBufferedImage() {
        inputBufferedImage = outputBufferedImage;
    }

//    Filter functions
    public void setSelectedFilter(String selectedFilter) {
        this.selectedFilter = selectedFilter;
    }
    public void applyFilter() throws IOException {
        switch (selectedFilter) {
            case "No filter" -> outputBufferedImage = inputBufferedImage;
            case "Black & White" -> {
                BufferedImage bwImage = new BufferedImage(inputBufferedImage.getWidth(), inputBufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
                Graphics2D bwGraphics = bwImage.createGraphics();
                bwGraphics.drawImage(inputBufferedImage, 0, 0, null);
                bwGraphics.dispose();
                outputBufferedImage = bwImage;
            }
            case "Tint" -> {
                BufferedImage tintImage = new BufferedImage(inputBufferedImage.getWidth(), inputBufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D tintGraphics = tintImage.createGraphics();
                tintGraphics.drawImage(inputBufferedImage, 0, 0, null);
                tintGraphics.dispose();
                int tintRed = 255; // replace with desired tint color
                int tintGreen = 0;
                int tintBlue = 0;
                for (int y = 0; y < tintImage.getHeight(); y++) {
                    for (int x = 0; x < tintImage.getWidth(); x++) {
                        int rgb = tintImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;
                        r = Math.min((int) (r + tintRed), 255);
                        g = Math.min((int) (g + tintGreen), 255);
                        b = Math.min((int) (b + tintBlue), 255);
                        rgb = (r << 16) | (g << 8) | b;
                        tintImage.setRGB(x, y, rgb);
                    }
                }
                outputBufferedImage = tintImage;
            }
            case "Invert Colors" -> {
                BufferedImage invertImage = new BufferedImage(inputBufferedImage.getWidth(), inputBufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D invertGraphics = invertImage.createGraphics();
                invertGraphics.drawImage(inputBufferedImage, 0, 0, null);
                Color invertColor = new Color(255, 255, 255);
                for (int x = 0; x < invertImage.getWidth(); x++) {
                    for (int y = 0; y < invertImage.getHeight(); y++) {
                        int rgb = invertImage.getRGB(x, y);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = (rgb & 0xFF);
                        r = invertColor.getRed() - r;
                        g = invertColor.getGreen() - g;
                        b = invertColor.getBlue() - b;
                        int newRGB = (r << 16) | (g << 8) | b;
                        invertImage.setRGB(x, y, newRGB);
                    }
                }
                invertGraphics.dispose();
                outputBufferedImage = invertImage;
            }
            case "Mosaic" -> {
                int blockSize = 10; // size of each block
                int width = inputBufferedImage.getWidth();
                int height = inputBufferedImage.getHeight();
                BufferedImage mosaicImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int y = 0; y < height; y += blockSize) {
                    for (int x = 0; x < width; x += blockSize) {
                        // calculate the average color of the block
                        int sumR = 0, sumG = 0, sumB = 0;
                        int count = 0;
                        for (int j = y; j < Math.min(y + blockSize, height); j++) {
                            for (int i = x; i < Math.min(x + blockSize, width); i++) {
                                int rgb = inputBufferedImage.getRGB(i, j);
                                sumR += (rgb >> 16) & 0xFF;
                                sumG += (rgb >> 8) & 0xFF;
                                sumB += rgb & 0xFF;
                                count++;
                            }
                        }
                        int avgR = sumR / count;
                        int avgG = sumG / count;
                        int avgB = sumB / count;
                        int avgRGB = (avgR << 16) | (avgG << 8) | avgB;

                        // fill the block with the average color
                        for (int j = y; j < Math.min(y + blockSize, height); j++) {
                            for (int i = x; i < Math.min(x + blockSize, width); i++) {
                                mosaicImage.setRGB(i, j, avgRGB);
                            }
                        }
                    }
                }
                outputBufferedImage = mosaicImage;
            }

            default -> {
            }
        }
    }

    public String getZipName() {
        return getId() + "." + outputFormat.toLowerCase();
    }
}