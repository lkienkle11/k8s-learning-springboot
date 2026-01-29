package com.testk8s.service_book.init;

import com.testk8s.service_book.entity.Book;
import com.testk8s.service_book.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookInit implements CommandLineRunner {

    private final IBookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        long count = bookRepository.count();
        if (count >= 15) {
            log.info("Books already initialized (count: {}), skipping initialization.", count);
            return;
        }

        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            String isbn = "ISBN-book" + i;

            if (bookRepository.findBookByIsbn(isbn) == null) {
                Book book = Book.builder()
                        .isbn(isbn)
                        .title("Book Title " + i)
                        .author("Author " + (random.nextInt(5) + 1))
                        .price(10.0 + (100.0 - 10.0) * random.nextDouble()) // Random price between 10 and 100
                        .publicationYear(2000 + random.nextInt(24)) // Year between 2000 and 2023
                        .publisher("Publisher " + (random.nextInt(5) + 1))
                        .genre("Genre " + (random.nextInt(5) + 1))
                        .build();
                bookRepository.save(book);
                log.info("Initialized book: {}", isbn);
            }
        }
    }
}
