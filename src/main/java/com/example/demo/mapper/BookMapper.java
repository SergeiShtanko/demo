package com.example.demo.mapper;

import com.example.demo.entity.BookEntity;

public interface BookMapper {
    BookEntity mapWithNonNullValues(BookEntity bookEntityFrom, BookEntity bookEntityTo);
}
