package com.users.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  private String firstName;

  private String lastName;

  @Column(name = "email", nullable = false, unique = true) private String email;

  public String getFirstName() { return firstName; }

  public String getLastName() { return lastName; }

  public String getEmail() { return email; }

  public Long getId() { return id; }
}
