package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Dailycard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailycardRepository extends JpaRepository<Dailycard, Long>{

}
