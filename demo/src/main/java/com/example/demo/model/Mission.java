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
  Long mId;
  String userId;
  String missionName;
  Date lastday;
}
