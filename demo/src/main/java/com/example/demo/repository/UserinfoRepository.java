package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
  public Userinfo findByUserIdAndUserPw(String userId, String userPw);
  public List<Userinfo> findByUserIdContaining(String userId);
}
