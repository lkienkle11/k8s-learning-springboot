package com.testk8s.service_book.service;

import com.testk8s.service_book.mapper.IBookMapper;
import com.testk8s.service_book.repository.IBookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl {
    IBookRepository bookRepo;

    IBookMapper bookMapper;

    public model.Book findByIsbn(String isbn) {
        return bookMapper.toBook(bookRepo.findBookByIsbn(isbn));
    }

    public List<model.Book> findAll() {
        return bookRepo.findAll().stream().map(bookMapper::toBook).toList();
    }
}
