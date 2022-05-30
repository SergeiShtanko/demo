package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.BookEntity;

public interface BookController {
    ResponseEntity createBook(BookEntity bookEntity);

    ResponseEntity getBookById(Long id);

    ResponseEntity getAll();

    ResponseEntity updateBook(Long id, BookEntity bookEntity);

    ResponseEntity patchBook(Long id, String title, String author, Integer year, Integer pageQuantity, String description, String publisher);

}
