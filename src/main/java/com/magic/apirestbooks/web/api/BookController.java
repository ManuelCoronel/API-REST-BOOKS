package com.magic.apirestbooks.web.api;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    List<Book> getAll(){
        return bookRepository.findAll();
    }

    @PostMapping
    Book create(@RequestBody Book libro){
        return bookRepository.save(libro);
    }
}
