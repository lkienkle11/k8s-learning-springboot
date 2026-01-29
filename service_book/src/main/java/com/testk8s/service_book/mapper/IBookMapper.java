package com.testk8s.service_book.mapper;

import com.testk8s.service_book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IBookMapper {
    IBookMapper INSTANCE = Mappers.getMapper(IBookMapper.class);

    model.Book toBook(Book book);
    Book toEntity(model.Book book);
}
