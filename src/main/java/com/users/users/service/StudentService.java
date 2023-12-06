package com.users.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.users.users.entity.Student;
import com.users.users.repository.StudentRepository;

@Service
public class StudentService {
  @Autowired StudentRepository studentRepository;

  public ResponseEntity<List<Student>> getAll() {
    return ResponseEntity.status(200).body(studentRepository.findAll());
  }

  public ResponseEntity<Student> get(Long id) {
    Student student = studentRepository.findById(id).orElse(null);

    if (student == null)
      return ResponseEntity.notFound().build();

    return ResponseEntity.status(200).body(student);
  }

  public ResponseEntity<Student> add(Student student) {
    Student createdStudent;

    boolean studentExists =
        studentRepository.findByEmail(student.getEmail()) != null ? true
                                                                  : false;

    if (studentExists)
      return ResponseEntity.badRequest().build();

    if (student.getEmail() == null || student.getFirstName() == null ||
        student.getLastName() == null)
      return ResponseEntity.badRequest().build();

    try {
      createdStudent = studentRepository.save(student);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }

    return ResponseEntity.status(200).body(createdStudent);
  }

  public ResponseEntity<Student> update(Student student) {
    return ResponseEntity.status(200).body(studentRepository.save(student));
  }

  public ResponseEntity<Student> delete(Long id) {
    Student student = studentRepository.findById(id).orElse(null);

    if (student != null) {
      studentRepository.deleteById(id);
      return ResponseEntity.status(200).body(student);
    }

    return ResponseEntity.notFound().build();
  }
}
