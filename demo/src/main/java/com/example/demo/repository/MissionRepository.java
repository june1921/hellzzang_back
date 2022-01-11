package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Mission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>{
  List<Mission> findByUserIdContaining(String userId);
}
