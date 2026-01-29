package com.testk8s.service_book.repository;

import com.testk8s.service_book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    Book findBookByIsbn(String isbn);
}
