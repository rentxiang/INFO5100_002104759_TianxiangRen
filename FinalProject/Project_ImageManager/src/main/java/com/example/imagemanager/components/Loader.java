package com.example.imagemanager.components;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;

// Loader class offers image formatting and save function
public class Loader {
    public static List<File> getFiles() throws IOException {
        FileChooser fileChooser = getImageFileChooser();
        fileChooser.setTitle("Choose Images");
        return fileChooser.showOpenMultipleDialog(null);
    }

    public static FileChooser getImageFileChooser() {
        FileChooser fileChooser = new javafx.stage.FileChooser();

        FileChooser.ExtensionFilter extFilterAll = new FileChooser.ExtensionFilter("All Supported Image Formats", "*.JPG", "*.JPEG", "*.PNG", "*.SVG", "*.BMP", "*.TIF", "*.TIFF");
        FileChooser.ExtensionFilter extFilterJpg = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPng = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter extFilterJpeg = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
        FileChooser.ExtensionFilter extFilterBmp = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
        FileChooser.ExtensionFilter extFilterTif = new FileChooser.ExtensionFilter("TIF files (*.tif)", "*.TIF");
        FileChooser.ExtensionFilter extFilterTiff = new FileChooser.ExtensionFilter("TIFF files (*.tiff)", "*.TIFF");

        fileChooser.setTitle("Please choose your images.");
        fileChooser.getExtensionFilters().addAll(extFilterAll, extFilterJpg, extFilterPng, extFilterJpeg, extFilterBmp, extFilterTif, extFilterTiff);

        return fileChooser;
    }

// FIle saved in a .zip file
    public static File getSaveFile(String formatName) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(formatName.toUpperCase() + " files (*." + formatName.toLowerCase()+")", "*." + formatName.toLowerCase());
        fileChooser.getExtensionFilters().addAll(extFilter);
        return fileChooser.showSaveDialog(null);
    }
}
