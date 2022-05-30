package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.BookisUpToDateException;

import java.util.List;

public interface BookService {
    BookEntity saveBook(BookEntity bookEntity) throws BookAlreadyExistsException;

    BookEntity getById(Long id) throws BookNotFoundException;

    List<BookEntity> getAll();

    BookEntity updateBook(Long id, BookEntity bookEntity) throws BookisUpToDateException;

    BookEntity patchBook(Long id, BookEntity bookEntity) throws BookNotFoundException;

}
