package com.testk8s.service_user.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl {
    @Value("${other-app.books.api}")
    @NonFinal
    String bookApi;

    RestTemplate restTemplate;

    public List<Book> getAllBooks() {
        String allBooksEndpoint = "/books/";
        ResponseEntity<List<Book>> response = restTemplate
                .exchange(
                        bookApi + allBooksEndpoint,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        return response.getBody();
    }
}
