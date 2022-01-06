package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Dailycard;
import com.example.demo.repository.DailycardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Dailycard> list = dailycardRepository.findAll();
		return list;
	}

  @GetMapping("/dailycard/{id}")
  @ResponseBody
	public Optional<Dailycard> boardView(@PathVariable("id") long id) {
		Optional<Dailycard> list = dailycardRepository.findById(id);
		return list;
	}


}
