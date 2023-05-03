package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "tbl_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

//    @JsonIgnore
    @OneToMany(mappedBy = "fkUser")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();


}
