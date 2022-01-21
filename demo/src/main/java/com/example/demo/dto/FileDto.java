package com.example.demo.dto;

public class FileDto {
    String uuid;
    String fileName;
    String contentType;

    public FileDto() {

    }

    public FileDto(String uuid, String fileName, String contentType) {
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
    }
    
}
