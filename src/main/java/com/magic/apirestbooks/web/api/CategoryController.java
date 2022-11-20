package com.magic.apirestbooks.web.api;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.model.Category;
import com.magic.apirestbooks.repository.CategoryRepository;
import com.magic.apirestbooks.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    ResponseEntity<List<Category>> obtenerCategorias(){
        try{
            return ResponseEntity.ok().body(categoryService.obtenerCategorias());
        } catch (Exception e){
            return (ResponseEntity<List<Category>>) ResponseEntity.badRequest();
        }
    }

    @PostMapping
    ResponseEntity<Category> guardarCategoria(@RequestBody Category categoria) {
        try{
            return ResponseEntity.ok().body(categoryService.guardarCategoria(categoria));
        } catch (Exception e){
            return (ResponseEntity<Category>) ResponseEntity.badRequest();
        }
    }
}