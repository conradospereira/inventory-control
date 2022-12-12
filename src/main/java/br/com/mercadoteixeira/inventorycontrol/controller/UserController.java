package br.com.mercadoteixeira.inventorycontrol.controller;

import br.com.mercadoteixeira.inventorycontrol.model.User;
import br.com.mercadoteixeira.inventorycontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.saveAndFlush(user));
    }
}


