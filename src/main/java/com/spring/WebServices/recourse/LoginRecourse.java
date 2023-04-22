package com.spring.WebServices.recourse;

import com.spring.WebServices.services.LoginServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginRecourse {

    private final LoginServices service;

    public LoginRecourse(LoginServices service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Boolean> login(String userName, String password){

        if(!service.validateLogin(userName, password)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        return ResponseEntity.ok().body(true);
    }

}
