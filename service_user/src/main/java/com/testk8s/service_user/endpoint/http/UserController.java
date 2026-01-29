package com.testk8s.service_user.endpoint.http;

import com.testk8s.service_user.service.UserServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserServiceImpl userService;

    @GetMapping("/hello")
    public ResponseEntity<String> testHello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/")
    public ResponseEntity<List<model.User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
}
