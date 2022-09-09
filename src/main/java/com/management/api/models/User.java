package com.management.api.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @Table(name="TB_USER")
@AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String cpf;
  @Column(nullable = false, unique = true)
  private String rg;
  @Column(nullable = false)
  private Date bornAt;
  @Column(nullable = false)
  private String motherName;
  @Column(nullable = false)
  private Date registeredAt;

}
