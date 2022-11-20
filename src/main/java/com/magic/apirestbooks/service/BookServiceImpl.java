package com.magic.apirestbooks.service;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private S3Service s3Service;

    @Override
    public List<Book> obtenerLibros() {
        return bookRepository.findAll().stream().peek(book -> book.setImagenUrl(s3Service.getObjectUrl(book.getImagenPath()))).collect(Collectors.toList());

    }

    @Override
    public Book obtenerLibroId(int id) {
        Optional<Book> libro = bookRepository.findById(id);
        return libro.get();
    }

    @Override
    public Book guardarLibro(Book libro) {
        libro.setImagenUrl(s3Service.getObjectUrl(libro.getImagenPath()));
        return bookRepository.save(libro);
    }

    @Override
    public void eliminarLibro(int id) {
        bookRepository.deleteById(id);
    }



}
