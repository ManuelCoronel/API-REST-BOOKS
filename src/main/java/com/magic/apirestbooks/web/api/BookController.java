package com.magic.apirestbooks.web.api;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.repository.BookRepository;
import com.magic.apirestbooks.service.BookServiceImpl;
import com.magic.apirestbooks.service.IBookService;
import com.magic.apirestbooks.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping
    ResponseEntity<List<Book>> obtenerLibros(){
        try{
            return ResponseEntity.ok().body(bookService.obtenerLibros());
        } catch (Exception e){
            return (ResponseEntity<List<Book>>) ResponseEntity.badRequest();
        }
    }

    @PostMapping
    ResponseEntity<Book> create(@RequestBody Book libro){
        try{
            return ResponseEntity.ok().body(bookService.guardarLibro(libro));
        } catch (Exception e){
            return (ResponseEntity<Book>) ResponseEntity.badRequest();
        }
    }

    @DeleteMapping(value = "/book",params = "id")
    ResponseEntity<String> delete(@RequestParam int id){
        try {
            bookService.eliminarLibro(id);
            return ResponseEntity.ok("Eliminado");
        }catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest().body("No se ha podido eliminar el libro");
        }
    }

}
