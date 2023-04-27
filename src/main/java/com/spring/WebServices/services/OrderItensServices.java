package com.spring.WebServices.services;

import com.spring.WebServices.entities.OrderItens;
import com.spring.WebServices.repository.OrderItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItensServices {

    @Autowired
    private OrderItensRepository repository;

    public OrderItens createNewOrderItem(OrderItens itens){
        return repository.save(itens);
    }

    public List<OrderItens> getAllOrderItens(){
        return repository.findAll();
    }

}
