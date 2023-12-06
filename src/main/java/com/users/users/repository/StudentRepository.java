package com.users.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.users.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Student findByEmail(String email);
}
