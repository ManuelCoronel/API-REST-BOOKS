package com.magic.apirestbooks.service;

import com.magic.apirestbooks.model.Category;
import com.magic.apirestbooks.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        category = new Category();
        category.setId(1L);
        category.setNombre("Literatura");
    }

    @Test
    void obtenerCategorias() {

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));
        assertNotNull(categoryService.obtenerCategorias());
    }

    @Test
    void guardarCategoria() {
        when(categoryRepository.save(any())).thenReturn(category);
        assertNotNull(categoryService.guardarCategoria(new Category()));
    }


}