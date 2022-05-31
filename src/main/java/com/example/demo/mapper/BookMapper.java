package com.example.demo.mapper;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.BookEntity;

public interface BookMapper {
    BookEntity mapWithNonNullValues(BookDTO bookEntityFrom, BookEntity bookEntityTo);
}
