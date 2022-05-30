package com.example.demo.mapper;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.BookEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapperDraft {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDTO(BookDTO bookFrom, @MappingTarget BookEntity bookTo);
}
