package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdProduct;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "cdCategory", nullable = false)
    private Category fkCategory;



    @ManyToOne
    @JoinColumn(name = "cdOrder")
    @JsonBackReference
    private Order fkOrder;
}
