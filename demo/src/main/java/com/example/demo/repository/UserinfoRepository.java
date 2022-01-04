package com.example.demo.repository;

import com.example.demo.model.Userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
  public Userinfo findByUseridAndUserpw(String userid, String userpw);
}
