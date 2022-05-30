package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    BookEntity findByTitleAndAuthorAndPublisher(String title, String author, String publisher);
    List<BookEntity> findAll();
}
