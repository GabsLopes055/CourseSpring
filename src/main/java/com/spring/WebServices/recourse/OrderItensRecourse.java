package com.spring.WebServices.recourse;

import com.spring.WebServices.entities.OrderItens;
import com.spring.WebServices.services.OrderItensServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItensRecourse {

    @Autowired
    private OrderItensServices services;

    @PostMapping
    public ResponseEntity<OrderItens> createNewOrderItem(@RequestBody OrderItens item){
        return ResponseEntity.ok().body(services.createNewOrderItem(item));
    }

    @GetMapping
    public ResponseEntity<List<OrderItens>> findAllOrderItem(){
        return ResponseEntity.ok().body(services.getAllOrderItens());
    }

}
