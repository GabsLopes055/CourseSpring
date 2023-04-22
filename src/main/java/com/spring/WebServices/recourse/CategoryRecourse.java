package com.spring.WebServices.recourse;

import com.spring.WebServices.entities.Category;
import com.spring.WebServices.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/category")
public class CategoryRecourse {
    @Autowired
    private CategoryServices service;

    //metodo para listar todas categorias
    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> listCategory = service.findAllCategory();
        return ResponseEntity.ok().body(listCategory);
    }

    //metodo para buscar categoria por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findCategoryById(id));
    }


    //metoodo para criar categoria
    @PostMapping
    public Category createNewCategory(@RequestBody Category category) {
        return service.createNewCategory(category);
    }


}
