package com.example.demo.controller;

import java.security.KeyStore.Entry;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Dailycard;
import com.example.demo.model.File;
import com.example.demo.repository.DailycardRepository;
import com.example.demo.service.FileService;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@CrossOrigin
@Controller
public class DailycardController {
  // 커밋
  @Autowired
  DailycardRepository dailycardRepository;
  FileService fileService;

  // 포스트 작성(Create)부
  
  // 파일 업로드(Upload)부
 	
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

  // 포스트 전체 조회부(Read)
  @GetMapping("/dailycard/list")
  @ResponseBody
  public List<Dailycard> cardList() {
    List<Dailycard> list = dailycardRepository.findAll();
    return list;
  }

  // 나만의 포스트 전체 조회부(Read.my)
  @GetMapping("/mydaily/list")
  @ResponseBody
  public List<Dailycard> mylist(Long userNum) {
    List<Dailycard> list = dailycardRepository.findByUserNum(userNum);
    return list;
  }

  // 포스트 1개 조회부
  @GetMapping("/dailycard/{id}")
  @ResponseBody
  public Optional<Dailycard> boardView(@PathVariable("id") long dId) {
    Optional<Dailycard> list = dailycardRepository.findById(dId);
    return list;
  }

  // 좋아요 버튼 처리(Update)부
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

  // 포스트 수정(Update)부
  @GetMapping("/dailycard/update/{id}")
  @ResponseBody
  public String boardUpdate(Model model, @PathVariable("id") long dId) {

    // user의 정보를 받아와야함
    Optional<Dailycard> data = dailycardRepository.findById(dId);
    Dailycard dailycard = data.get();
    model.addAttribute("dailycard", dailycard);

    dailycardRepository.save(dailycard);
    return "board/update";
  }

  @PostMapping("/dailycard/update/{id}")
  @ResponseBody
  public String boardUpdate(@ModelAttribute Dailycard dailycard, @PathVariable("id") long dId) {
    dailycard.setDId(dId);
    dailycardRepository.save(dailycard);
    return "redirect:/dailycard/" + dId;
  }

  // 포스트 삭제(Delete)부
  @GetMapping("/dailycard/delete/{id}")
  public String boardDelete(@PathVariable("id") long dId) {
    dailycardRepository.deleteById(dId);
    return "redirect:/board/list";
  }
}
