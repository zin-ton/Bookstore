package com.example.bookstore.controlers;

import com.example.bookstore.models.Users;
import com.example.bookstore.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
        if (usersRepository.findByLogin(user.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody Users requestUser){
        Users user = usersRepository.findByLogin(requestUser.getLogin()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(requestUser.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        }
    }
}
