package com.testk8s.service_user.endpoint.http;

import com.testk8s.service_user.service.BookServiceImpl;
import com.testk8s.service_user.service.UserServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users-books")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookServiceImpl bookService;

    @GetMapping("/")
    public List<model.Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
