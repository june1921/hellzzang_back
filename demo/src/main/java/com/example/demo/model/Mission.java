package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mission {
  @Id @GeneratedValue
  long m_id;
  String userid;
  String mission_name;
  Date last_day;
}
