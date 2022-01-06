package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Userinfo {
  @Id @GeneratedValue
  long uId;
  String name;
  String nickname;
  String userid;
  String userpw;
}
