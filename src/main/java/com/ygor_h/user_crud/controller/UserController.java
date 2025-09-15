package com.ygor_h.user_crud.controller;

import com.ygor_h.user_crud.business.UserService;
import com.ygor_h.user_crud.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> getUserByCpf(@RequestParam String cpf){
        return ResponseEntity.ok(userService.getUserByCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByCpf(@RequestParam String cpf){
        userService.deleteUserByCpf(cpf);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserByCpf(@RequestParam String cpf, @RequestBody User user){
        userService.updateUserByCpf(cpf, user);
        return ResponseEntity.ok().build();
    }
}
