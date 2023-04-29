package com.example.imagemanager.components;
import com.drew.imaging.ImageProcessingException;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Interfaces for image implementations
public interface ImageAPI {
    Integer getNumberOfImages();

    List<Image> addMultipleImages(List<File> files) throws ImageProcessingException, IOException;

    void addSingleImage(Image image);

    void deleteSingleImage(Integer targetId);

    void deleteAllImages();

    void downloadSingleImage(Integer targetId) throws IOException;

    void downloadAllImages() throws IOException;
}
