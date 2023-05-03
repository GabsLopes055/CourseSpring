package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.*;
import com.spring.WebServices.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdOrder;

    @Column(name = "DATA")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate moment;

    private OrderStatus orderStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cdUser")
    private User fkUser;

    @OneToMany(mappedBy = "cdOrderItens.order")
    private Set<OrderItens> items;



}
