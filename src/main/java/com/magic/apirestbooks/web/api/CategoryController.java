package com.magic.apirestbooks.web.api;

import com.magic.apirestbooks.model.Category;
import com.magic.apirestbooks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @PostMapping
    Category create(@RequestBody Category categoria){
        return categoryRepository.save(categoria);
    }
}
