package com.spring.WebServices.recourse;

import com.spring.WebServices.entities.Order;
import com.spring.WebServices.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/orders")
@RestController
public class OrderRecourse {
    @Autowired
    public OrderServices service;

    //metodo para buscar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders(){
        List<Order> listOrder = service.findAllOrder();
        return ResponseEntity.ok().body(listOrder);
    }

    //metodo para buscar pedido por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Order>> findOrderById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findOrderBy(id));
    }

    //metodo para criar um novo pedido
    @PostMapping
    public Order createNewOrder(@RequestBody Order order) {
        return service.createNewOrder(order);
    }

}
