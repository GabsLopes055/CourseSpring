package com.spring.WebServices.services;

import com.spring.WebServices.entities.User;
import com.spring.WebServices.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServices {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public LoginServices(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Boolean validateLogin(String userName, String password) {

        Optional<User> findUser = repository.findByUserName(userName);

        if (findUser.isEmpty()) {
            return false;
        }
        return encoder.matches(password, findUser.get().getPassword());


    }

}
