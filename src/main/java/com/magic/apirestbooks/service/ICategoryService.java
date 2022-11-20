package com.magic.apirestbooks.service;

import com.magic.apirestbooks.model.Category;

import java.util.List;

public interface ICategoryService {

    public List<Category> obtenerCategorias();
    public Category guardarCategoria(Category categoria);
}
