package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class File {
    @Id @GeneratedValue
    Long fId;
    String fileName;
    long fileSize;
    String filePath;
    
}
