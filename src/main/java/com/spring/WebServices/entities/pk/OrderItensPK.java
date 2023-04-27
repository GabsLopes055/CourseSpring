package com.spring.WebServices.entities.pk;

import com.spring.WebServices.entities.Order;
import com.spring.WebServices.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class OrderItensPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "cdProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cdOrder")
    private Order order;

}
