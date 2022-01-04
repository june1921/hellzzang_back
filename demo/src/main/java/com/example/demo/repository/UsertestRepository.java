package com.example.demo.repository;

import com.example.demo.model.Usertest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsertestRepository extends JpaRepository<Usertest, Long> {
  public Usertest findByIdAndPw(String id, String pw);
}
