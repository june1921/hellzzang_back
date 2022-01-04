package com.example.demo;

import java.util.List;

import com.example.demo.model.Usertest;
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

}
