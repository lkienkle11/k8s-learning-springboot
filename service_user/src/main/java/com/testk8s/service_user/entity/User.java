package com.testk8s.service_user.entity;

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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Username cannot be empty")
    @Column(nullable = false, unique = true, length = 60)
    String username;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false, length = 100)
    String name;

    @Min(value = 0, message = "Age must be non-negative")
    @Column(nullable = false)
    Integer age;
}
