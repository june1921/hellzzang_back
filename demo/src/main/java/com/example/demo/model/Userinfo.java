package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Userinfo {
  @Id @GeneratedValue
  Long uId;
  String name;
  String nickname;
  String userId;
  String userPw;
}
