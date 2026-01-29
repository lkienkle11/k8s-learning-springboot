package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    Long id;
    String title;
    String author;
    String isbn;
    Double price;
    Integer publicationYear;
    String publisher;
    String genre;
}
