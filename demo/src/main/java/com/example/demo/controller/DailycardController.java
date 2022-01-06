package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Dailycard;
import com.example.demo.repository.DailycardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class DailycardController {
  @Autowired
  DailycardRepository dailycardRepository;

  @GetMapping("/write")
  public String write() {
    return "write";
  }

  @PostMapping("/write")
  @ResponseBody
  public Dailycard signupPost(@ModelAttribute Dailycard dailycard) {
    dailycardRepository.save(dailycard);
    return dailycard;
  }
  
  @GetMapping("/dailycard/list")
  @ResponseBody
	public List<Dailycard> cardList() {
		List<Dailycard> list=dailycardRepository.findAll();
    return list;
	}

  @GetMapping("/mydaily/list")
  @ResponseBody
  public List<Dailycard> mylist(Long u_id){
    List<Dailycard> list = dailycardRepository.findByUserNum(u_id);
    return list;
  }
}
