package com.magic.apirestbooks.repository;

import com.magic.apirestbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
