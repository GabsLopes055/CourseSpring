package com.spring.WebServices.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tbl_orderItens")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItens implements Serializable {

    public static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdOrderItens;

    private Double price;

    private Integer quantity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cdOrder")
    private Order order;

    @OneToMany(mappedBy = "orderItens")
    @JsonManagedReference
    private List<Product> product = new ArrayList<>();
}
