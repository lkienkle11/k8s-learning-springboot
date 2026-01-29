package com.testk8s.service_book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "ISBN cannot be empty")
    @Column(nullable = false, length = 13, unique = true)
    String isbn;

    @NotBlank(message = "Title cannot be empty")
    @Column(nullable = false, length = 200)
    String title;

    @NotBlank(message = "Author cannot be empty")
    @Column(nullable = false, length = 100)
    String author;

    @Min(value = 0, message = "Price must be non-negative")
    @Column(nullable = false)
    Double price;

    @Min(value = 0, message = "Publication year must be non-negative")
    @Column
    Integer publicationYear;

    @NotBlank(message = "Publisher cannot be empty")
    @Column(nullable = false, length = 100)
    String publisher;

    @Column
    String genre;
}
