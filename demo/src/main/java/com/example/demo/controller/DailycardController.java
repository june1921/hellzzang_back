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
  //ㅋ
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

  @GetMapping("/mydaily/list")
  @ResponseBody
  public List<Dailycard> mylist(Long userNum) {
    List<Dailycard> list = dailycardRepository.findByUserNum(userNum);
    return list;
  }

  @GetMapping("/dailycard/{id}")
  @ResponseBody
  public Optional<Dailycard> boardView(@PathVariable("id") long dId) {
    Optional<Dailycard> list = dailycardRepository.findById(dId);
    return list;
  }

  // 좋아요 버튼 처리(업데이트)부

  @GetMapping("/dailycard/likebtn/{id}")
  @ResponseBody
  public String likeBtn(Model model, @PathVariable("id") long dId) {
    Optional<Dailycard> data = dailycardRepository.findById(dId);
    Dailycard dailycard = data.get();
    model.addAttribute("dailycard", dailycard);

    dailycard.setLikeCount(dailycard.getLikeCount() + 1);
    dailycardRepository.save(dailycard);
    return "dailycard/likebtn";
  }

  /*
  @GetMapping("/dailycard/likebtn/{id}")
  @ResponseBody
  public String likeBtn(Model model, @PathVariable("id") long dId) {
    Optional<Dailycard> data = dailycardRepository.findById(dId);
    Dailycard dailycard = data.get();
    model.addAttribute("dailycard", dailycard);
    return "dailycard/likebtn";
  }

  @PostMapping("/dailycard/liketbtn/{id}")
  public String likeBtnUpdate(@ModelAttribute Dailycard dailycard, @PathVariable("id") long dId) {
    dailycard.setLikeCount(dailycard.getLikeCount() + 1);
    dailycardRepository.save(dailycard);
    return "String";
  }
  */

  @PostMapping("/dailycard/update/{id}")
  public String boardUpdate(@ModelAttribute Dailycard dailycard, @PathVariable("id") long dId) {
    dailycardRepository.save(dailycard);
    return "redirect:/dailycard/" + dId;
  }

  @GetMapping("/dailycard/delete/{id}")
  public String boardDelete(@PathVariable("id") long dId) {
    dailycardRepository.deleteById(dId);
    return "redirect:/board/list";
  }
}
