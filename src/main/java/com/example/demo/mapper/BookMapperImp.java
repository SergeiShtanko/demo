package com.example.demo.mapper;

import com.example.demo.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImp implements BookMapper{
    @Override
    public BookEntity mapWithNonNullValues(BookEntity bookEntityFrom, BookEntity bookEntityTo) {
        if (bookEntityFrom.getAuthor() != null){
            bookEntityTo.setAuthor(bookEntityFrom.getAuthor());
        }
        if (bookEntityFrom.getTitle() != null){
            bookEntityTo.setTitle(bookEntityFrom.getTitle());
        }
        if (bookEntityFrom.getYear() != null){
            bookEntityTo.setYear(bookEntityFrom.getYear());
        }
        if (bookEntityFrom.getPageQuantity()!= null){
            bookEntityTo.setPageQuantity(bookEntityFrom.getPageQuantity());
        }
        if (bookEntityFrom.getDescription() != null){
            bookEntityTo.setDescription(bookEntityFrom.getDescription());
        }
        if (bookEntityFrom.getPublisher() != null){
            bookEntityTo.setPublisher(bookEntityFrom.getPublisher());
        }
        return bookEntityTo;
    }
}
