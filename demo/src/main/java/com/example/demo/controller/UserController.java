package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public Map<String, Object> signinPost(@ModelAttribute Userinfo userinfo, HttpServletResponse response) {
		Userinfo dbUser = 
			userinfoRepository.findByUseridAndUserpw(
				userinfo.getUserid(), userinfo.getUserpw());
		Map<String, Object> map = new HashMap<>();
    if(dbUser != null){
      map.put("code", 200);
      map.put("msg","success");
    }else{
      map.put("code",201);
      map.put("msg","fail");
    }

    Cookie cookie = new Cookie("memberId", String.valueOf(userinfo.getUserid())); response.addCookie(cookie);


		return map;
	}
}
