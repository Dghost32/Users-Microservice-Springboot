package com.users.users.service;

import com.users.users.entity.User;
import com.users.users.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired UserRepository userRepository;

  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.status(200).body(userRepository.findAll());
  }

  public ResponseEntity<User> get(Long id) {
    User user = userRepository.findById(id).orElse(null);

    if (user == null)
      return ResponseEntity.notFound().build();

    return ResponseEntity.status(200).body(user);
  }

  public ResponseEntity<User> add(User user) {
    if (user.getEmail() == null || user.getFirstName() == null ||
        user.getLastName() == null)
      return ResponseEntity.badRequest().build();

    boolean exists =
        userRepository.findByEmail(user.getEmail()) != null ? true : false;

    if (exists)
      return ResponseEntity.badRequest().build();

    User createdUser;
    try {
      createdUser = userRepository.save(user);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }

    return ResponseEntity.status(200).body(createdUser);
  }

  public ResponseEntity<User> update(User user) {
    return ResponseEntity.status(200).body(userRepository.save(user));
  }

  public ResponseEntity<User> delete(Long id) {
    User user = userRepository.findById(id).orElse(null);

    if (user == null)
      return ResponseEntity.notFound().build();

    userRepository.deleteById(id);
    return ResponseEntity.status(200).body(user);
  }
}
