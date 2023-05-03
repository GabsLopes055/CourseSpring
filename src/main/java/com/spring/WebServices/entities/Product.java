package com.spring.WebServices.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_product")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cdProduct")
    private Long cdProduct;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "cdCategory", nullable = false)
    private Category fkCategory;

    @OneToMany(mappedBy = "cdOrderItens.product")
    private Set<OrderItens> items = new HashSet<>();

    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();

        for(OrderItens x : items){
            set.add(x.getOrder());
        }
        return set;
    }

}
