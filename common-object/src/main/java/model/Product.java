package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Long id;
    String codeProduct;
    String name;
    String description;
    Double price;
    String category;
    String brand;
    Integer stockQuantity;
    String sku;
    String imageUrl;
}
