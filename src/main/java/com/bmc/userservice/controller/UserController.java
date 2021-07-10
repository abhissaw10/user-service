package com.bmc.userservice.controller;

import com.bmc.userservice.exception.InvalidInputException;
import com.bmc.userservice.model.User;
import com.bmc.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/users")
    public ResponseEntity<User> register(@RequestBody User user) throws InvalidInputException {
       return ResponseEntity.ok(userService.register(user));
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        return ResponseEntity.ok(userService.getUser(id));
    }

}
