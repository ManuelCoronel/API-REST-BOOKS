package com.magic.apirestbooks.service;

import com.magic.apirestbooks.model.Book;
import com.magic.apirestbooks.model.Category;
import com.magic.apirestbooks.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private S3Service s3Service;
    private Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        book = new Book();
        book.setId(1);
        book.setTitulo("Elder Ring");
        book.setCategoria(new Category());
        book.setImagenPath("");
        book.setImagenUrl("");
    }

    @Test
    void obtenerLibros() {

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        when(s3Service.getObjectUrl(anyString())).thenReturn("imagen path");
        assertNotNull(bookService.obtenerLibros());
    }

    @Test
    void obtenerLibroId() {
        when(bookRepository.findById(anyInt())).thenReturn(Optional.ofNullable(book));
        assertNotNull(bookService.obtenerLibroId(anyInt()));
    }


    @Test
    void guardarLibro() {
        when(bookRepository.save(any())).thenReturn((book));
        when(s3Service.getObjectUrl(anyString())).thenReturn("");
        assertNotNull(bookService.guardarLibro(new Book()));
    }
}