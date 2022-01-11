package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class MissionController {
  @Autowired
  MissionRepository missionRepository;
  
  @GetMapping("/mission")
  @ResponseBody
  public List<Mission> dday(
    String userId){
      List<Mission> row = missionRepository.findByUserIdContaining(userId);
    return row;
  }
}
