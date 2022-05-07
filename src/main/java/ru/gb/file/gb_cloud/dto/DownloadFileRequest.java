package ru.gb.file.gb_cloud.dto;

import java.nio.file.Path;

public class DownloadFileRequest implements BasicRequest{

    private String pathOfFile;
    private String fileName;

    public String getPathOfFile() {
        return pathOfFile;
    }

    public DownloadFileRequest(String pathOfFile, String fileName) {
        this.pathOfFile = pathOfFile;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String getType() {
        return "download";
    }
}
