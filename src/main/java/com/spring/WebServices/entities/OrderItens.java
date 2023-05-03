package com.spring.WebServices.entities;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.WebServices.entities.pk.OrderItensPK;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tbl_orderItens")
@Data
@Getter
@Setter
@NoArgsConstructor
public class OrderItens{

    @EmbeddedId
    private OrderItensPK cdOrderItens = new OrderItensPK();

    private Double price;

    private Integer quantity;

    public OrderItens(Order order, Product product, Double price, Integer quantity){
        cdOrderItens.setOrder(order);
        cdOrderItens.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    public Order getOrder(){
        return cdOrderItens.getOrder();
    }

    public void setOrder(Order order){
        cdOrderItens.setOrder(order);
    }

    public Product getProduct(){
        return cdOrderItens.getProduct();
    }

    public void setProduct(Product product){
        cdOrderItens.setProduct(product);
    }
//



}
