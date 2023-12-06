package com.users.users.controller;

import com.users.users.entity.User;
import com.users.users.service.UserService;
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

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> get(@PathVariable("id") Long id) {
    return userService.get(id);
  }

  @PostMapping
  public ResponseEntity<User> add(@RequestBody User user) {
    return userService.add(user);
  }

  @PutMapping
  public ResponseEntity<User> update(@RequestBody User user) {
    return userService.update(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> delete(@PathVariable("id") Long id) {
    return userService.delete(id);
  }
}
