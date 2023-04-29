package com.example.imagemanager.components;
import java.io.File;

// Media class served as upperclass of Image class, holds a list of general attributes
public class Media {
    private static int identification = 0;
    private final int id;
    private final File file;
    private final String fileName;

    public Media(File file) {
        identification++;
        this.id = identification;
        this.file = file;
        this.fileName = file.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return fileName;
    }
}
