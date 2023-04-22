package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.WebServices.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_order")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long cdOrder;

    @Column(name = "data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate moment;

    private OrderStatus orderStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cdUser", nullable = false)
    private User fkUser;


}
