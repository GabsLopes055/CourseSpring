package com.spring.WebServices.recourse;

import com.spring.WebServices.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.WebServices.services.UserServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserRecourse {

    @Autowired
    private UserServices service;

    //endpoint para buscar todos usuários
    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        List<User> users = service.findAllUser();
        return ResponseEntity.ok().body(users);
    }

    //endpoint para buscar usuario por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findUserById(id));
    }

    @PostMapping
    public User saveNewClient(@RequestBody User user) {
        return service.saveUser(user);
    }

}
