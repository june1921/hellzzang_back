package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usertest {
  @Id @GeneratedValue
  long num;
  String name;
  String id;
  String pw;
}
