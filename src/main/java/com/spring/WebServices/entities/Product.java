package com.spring.WebServices.entities;

import jakarta.persistence.*;
import lombok.Data;

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

}
