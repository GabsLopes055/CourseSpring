package com.spring.WebServices.services;

import com.spring.WebServices.entities.User;
import com.spring.WebServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    //metodo para buscar todos usuarios
    public List<User> findAllUser() {
        return repository.findAll();
    }

    //metodo para buscar usuários por ID
    public Optional<User> findUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user;
        }
        return null;
    }

    //metodo para salvar usuario
    public User saveUser(User user) {


        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);
    }

    public void deletarUser(Long id) {
        repository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User userUpdate = repository.getReferenceById(id);
        updateData(userUpdate, user);
        return repository.save(userUpdate);
    }

    private void updateData(User userUpdate, User user) {
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhone(user.getPhone());
    }
}
