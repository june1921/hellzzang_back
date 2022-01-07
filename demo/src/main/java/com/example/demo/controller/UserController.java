package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.example.demo.model.Dailycard;
import com.example.demo.model.Userinfo;
import com.example.demo.repository.DailycardRepository;
import com.example.demo.repository.UserinfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserinfoRepository userinfoRepository;

  @Autowired
  DailycardRepository dailycardRepository;

  @Autowired
	HttpSession session;


  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }

  @PostMapping("/signup")
  @ResponseBody
  public Userinfo signupPost(@ModelAttribute Userinfo userinfo) {
    System.out.println(userinfo);
    userinfoRepository.save(userinfo);
    return userinfo;
  }

  @GetMapping("/login")
  public String signin() {
    return "login";
  }

  @PostMapping("/login")
  @ResponseBody
  public Map<String, Object> signinPost(@ModelAttribute Userinfo userinfo) {
    Userinfo dbUser = userinfoRepository.findByUseridAndUserpw(
        userinfo.getUserid(), userinfo.getUserpw());
    Map<String, Object> map = new HashMap<>();
    if (dbUser != null) {
      map.put("code", 200);
      map.put("msg", "success");
    } else {
      map.put("code", 201);
      map.put("msg", "fail");
    }
    return map;
  }

  @GetMapping("/output")
  @ResponseBody
  public List<Userinfo> output(String userid) {
    List<Userinfo> list = userinfoRepository.findByUseridContaining(userid);
    return list;
  }
}
