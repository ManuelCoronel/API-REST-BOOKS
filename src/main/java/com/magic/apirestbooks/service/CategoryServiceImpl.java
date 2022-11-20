package com.magic.apirestbooks.service;

import com.magic.apirestbooks.model.Category;
import com.magic.apirestbooks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements  ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> obtenerCategorias() {
        return categoryRepository.findAll();
    }

    @Override
    public Category guardarCategoria(Category categoria) {
        return categoryRepository.save(categoria);
    }
}
