package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Dailycard {
  @Id @GeneratedValue
  Long dId;
  String dailyName;
  long likeCount;
  String dailyContent;
  Long userNum;
}
