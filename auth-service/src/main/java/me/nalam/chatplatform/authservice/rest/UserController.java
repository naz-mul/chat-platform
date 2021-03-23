package me.nalam.chatplatform.authservice.rest;

import me.nalam.chatplatform.authservice.model.User;
import me.nalam.chatplatform.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired private UserRepository userRepository;

  @PostMapping(value = "/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    try {
      User newUser = userRepository.save(new User(user.getName()));
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    } catch (Exception ex) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
