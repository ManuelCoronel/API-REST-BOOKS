package com.magic.apirestbooks.service;


import com.magic.apirestbooks.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookService {

    public List<Book> obtenerLibros();
    public Book obtenerLibroId(int id);

    public Book guardarLibro(Book libro);
    public  void eliminarLibro(int id);
}
