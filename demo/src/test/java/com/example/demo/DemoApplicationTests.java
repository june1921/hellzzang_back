package com.example.demo;

import java.util.List;

import com.example.demo.model.Dailycard;
import com.example.demo.model.Mission;
import com.example.demo.model.Usertest;
import com.example.demo.repository.DailycardRepository;
import com.example.demo.repository.MissionRepository;
import com.example.demo.repository.UsertestRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {



  @Autowired
  UsertestRepository usertestRepository;
	@Test
	void contextLoads() {
    List<Usertest> list = usertestRepository.findAll();
    System.out.println(list);
	}

  @Autowired
  MissionRepository missionRepository;
  
  @Autowired
  DailycardRepository dailycardRepository;
  @Test
  void testdday2(){
    List<Dailycard> list = dailycardRepository.findAll();
    System.out.println(list);
  }

}
