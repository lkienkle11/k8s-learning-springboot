package com.testk8s.service_product.entity;

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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Code Product cannot be empty")
    @Column(nullable = false, unique = true, length = 50)
    String codeProduct;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false, length = 100)
    String name;

    @Column
    String description;

    @Min(value = 0, message = "Price must be non-negative")
    @Column(nullable = false)
    Double price;

    @NotBlank(message = "Category cannot be empty")
    @Column(nullable = false, length = 50)
    String category;

    @Column
    String brand;

    @Min(value = 0, message = "Stock Quantity must be non-negative")
    @Column
    Integer stockQuantity;

    @Column
    String sku;

    @Column
    String imageUrl;
}
