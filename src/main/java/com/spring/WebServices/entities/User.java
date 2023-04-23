package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "tbl_user")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long cdUser;

    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String userName;

    @Column(unique = true)
    @Email(message = "Email não é válido")
    private String email;

    @Column(unique = true)
    private String phone;

    private String password;
    
    private String userStatus;

    @OneToMany(mappedBy = "fkUser")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();


}
