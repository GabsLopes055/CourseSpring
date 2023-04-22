package com.spring.WebServices.services;

import com.spring.WebServices.entities.Order;
import com.spring.WebServices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository repository;

    //metodo para listar todos pedidos
    public List<Order> findAllOrder(){
        return repository.findAll();
    }

    public Optional<Order> findOrderBy(Long id) {
        Optional<Order> order = repository.findById(id);
        if(order.isPresent()){
            return order;
        }
        return null;
    }

    //metodo para salvar um pedido
    public Order createNewOrder(Order order) {
        return repository.save(order);
    }

}
