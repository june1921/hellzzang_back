package com.example.demo.repository;

import com.example.demo.model.File;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  FileRepository extends JpaRepository<File, Long> {

	File findByfId(long fId);
}