package com.example.imagemanager;


import com.drew.imaging.ImageProcessingException;
import com.example.imagemanager.components.Image;
import com.example.imagemanager.components.Loader;
import com.example.imagemanager.components.Panel;
import com.example.imagemanager.components.Services;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    @FXML
    public VBox imageViewContainer;
    public ScrollPane imageViewScrollPane;
    Services imageList = new Services();
    private List<File> files;
    @FXML
    private VBox uploadDialog;

    public void addImageAction() throws IOException, ImageProcessingException {
        // Add image from file and add into imageList
        files = Loader.getFiles();
        List<Image> addedImages = imageList.addMultipleImages(files);

        // Create UI components for image files
        if (imageList.getNumberOfImages() > 0) {
            // Visibility setting of relative components
            imageViewScrollPane.setVisible(true);
            uploadDialog.setVisible(false);
        }

        for (Image image : addedImages) {
            // Create panel for each image file
            Panel imagePanel = new Panel(image);

            imagePanel.getDeleteBtn().setOnAction(event -> {
                // Get the parent node and its fx:id
                String IdToDelete = imagePanel.getPanel().getId();
                // Download respective image in the imageList with fx:id
                imageList.deleteSingleImage(Integer.parseInt(IdToDelete));
                imageViewContainer.getChildren().remove(imagePanel.getPanel());
            });

            imagePanel.getDownloadBtn().setOnAction(event -> {
                try {
                    // Get the parent node and its fx:id
                    String IdToDownload = imagePanel.getPanel().getId();
                    // Download respective image in the imageList with fx:id
                    imageList.downloadSingleImage(Integer.parseInt(IdToDownload));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            imageViewContainer.getChildren().add(imagePanel.getPanel());
        }
    }

    // image format & size converter
    public void downloadAllAction() throws IOException {
        imageList.downloadAllImages();
    }

    public void deleteAllImagesAction() {
        // Delete items in imageList
        imageList.deleteAllImages();
        // Delete panels in imageViewContainer
        imageViewContainer.getChildren().clear();
        imageViewScrollPane.setVisible(false);
        uploadDialog.setVisible(true);
    }
}