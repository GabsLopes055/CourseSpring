package com.spring.WebServices.services;

import com.spring.WebServices.entities.Category;
import com.spring.WebServices.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repository;

    //metodo para buscar todas categorias
    public List<Category> findAllCategory(){
        return repository.findAll();
    }

    //metodo para buscar categoria por id
    public Optional<Category> findCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        if(category.isPresent()) {
            return category;
        }
        return null;
    }

    //metodo para criar uma nova categoria
    public Category createNewCategory(Category category) {
        return repository.save(category);
    }


}
