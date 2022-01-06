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
  long d_id;
  // long m_id;
  String daily_name;
  long like_count;
  String daily_content;

  @ManyToOne
  @JoinColumn(name="mission_id")
  Mission mission;

  @Override
  public String toString(){
    return d_id + daily_name + like_count ;
  }
}
