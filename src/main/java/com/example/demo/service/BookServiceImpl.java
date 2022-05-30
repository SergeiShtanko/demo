package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.BookisUpToDateException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    @Override
    public BookEntity saveBook(BookEntity bookEntity) throws BookAlreadyExistsException {
        if(bookRepository.findByTitleAndAuthorAndPublisher(bookEntity.getTitle(), bookEntity.getAuthor(),
                bookEntity.getPublisher()) != null){
            throw new BookAlreadyExistsException("Book already exists");
        }
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity getById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found by Id"));
    }

    @Override
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity updateBook(Long id, BookEntity bookEntity) throws BookisUpToDateException {
        Optional<BookEntity> bookEntityToCompare = bookRepository.findById(id);
        if (bookEntityToCompare.equals(Optional.ofNullable(bookEntity))){
            throw new BookisUpToDateException("Book is already up to date");
        } else {
            return bookRepository.save(bookEntity);
        }
    }

    @Override
    public BookEntity patchBook(Long id, BookEntity bookEntity) throws BookNotFoundException {
        BookEntity bookEntityTo = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found by Id"));
        bookMapper.mapWithNonNullValues(bookEntity, bookEntityTo);
        return bookRepository.save(bookEntityTo);
    }
}
