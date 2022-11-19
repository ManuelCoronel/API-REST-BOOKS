package com.magic.apirestbooks.web.api;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.repository.BookRepository;
import com.magic.apirestbooks.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    List<Book> getAll(){
        return bookRepository.findAll().stream().peek(book -> book.setImagenUrl(s3Service.getObjectUrl(book.getImagenPath()))).collect(Collectors.toList());
    }

    @PostMapping
    Book create(@RequestBody Book libro){
        bookRepository.save(libro);
        libro.setImagenUrl(s3Service.getObjectUrl(libro.getImagenPath()));
        return libro;
    }
}
