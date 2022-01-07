package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Mission {
  @Id @GeneratedValue
  long m_id;
  //String userid;
  String mission_name;
  Date last_day;

  //@ToString.Exclude
  //@OneToMany(mappedBy="mission", fetch = FetchType.EAGER)//player엔티티에서 manyToOne로 성언한 변수 이름을 넣음.
  //List<Dailycard> dailycards;
  
}
