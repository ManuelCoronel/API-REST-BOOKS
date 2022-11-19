package com.magic.apirestbooks.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String titulo;

    private String imagenPath;

    private String imagenUrl;
}
