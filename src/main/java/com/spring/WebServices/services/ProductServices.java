package com.spring.WebServices.services;

import com.spring.WebServices.entities.Product;
import com.spring.WebServices.entities.User;
import com.spring.WebServices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    //metodo para buscar todos produtos
    public List<Product> findAllProducts(){
        List<Product> listProduct = repository.findAll();
        return listProduct;
    }

    //metodo para criar um novo produto
    public Product createNewProduct(Product product){

        return repository.save(product);

    }


}
