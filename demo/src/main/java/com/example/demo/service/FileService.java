package com.example.demo.service;

import com.example.demo.model.File;
import com.example.demo.repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	FileRepository fileRepository;
	
	public void save(File file) {
		File f = new File();
		f.setFileName(file.getFileName());
		f.setFileSize(file.getFileSize());
		f.setFilePath(file.getFilePath());
		
		fileRepository.save(f);
	}
}