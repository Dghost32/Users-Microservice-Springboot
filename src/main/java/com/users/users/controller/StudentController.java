package com.users.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.users.entity.Student;
import com.users.users.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
  @Autowired private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<Student>> getAll() {
    return studentService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> get(@PathVariable("id") Long id) {
    return studentService.get(id);
  }

  @PostMapping
  public ResponseEntity<Student> add(@RequestBody Student student) {
    return studentService.add(student);
  }

  @PutMapping
  public ResponseEntity<Student> update(@RequestBody Student student) {
    return studentService.update(student);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Student> delete(@PathVariable("id") Long id) {
    return studentService.delete(id);
  }
}
