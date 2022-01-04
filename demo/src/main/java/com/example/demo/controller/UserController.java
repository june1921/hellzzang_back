package com.example.demo.controller;

import com.example.demo.model.Userinfo;
import com.example.demo.repository.UserinfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserinfoRepository userinfoRepository;
  @GetMapping("/signup")
  public String signup(){
    return "signup";
  }
  @PostMapping("/signup")
  @ResponseBody
  public Userinfo signupPost(@ModelAttribute Userinfo userinfo){
    userinfoRepository.save(userinfo);
    return userinfo;
  }
}
