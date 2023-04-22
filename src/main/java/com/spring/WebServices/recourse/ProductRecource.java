package com.spring.WebServices.recourse;

import com.spring.WebServices.entities.Product;
import com.spring.WebServices.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductRecource {

    @Autowired
    private ProductServices service;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok().body(service.findAllProducts());
    }

    //metodo para criar um novo produto
    @PostMapping
    public Product createNewProduct(@RequestBody Product product){
        return service.createNewProduct(product);
    }

}
