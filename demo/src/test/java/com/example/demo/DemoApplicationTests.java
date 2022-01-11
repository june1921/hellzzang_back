package com.example.demo;

import java.util.List;

import com.example.demo.model.Dailycard;
import com.example.demo.model.Mission;
import com.example.demo.repository.DailycardRepository;
import com.example.demo.repository.MissionRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  MissionRepository missionRepository;
  
  @Autowired
  DailycardRepository dailycardRepository;

}
