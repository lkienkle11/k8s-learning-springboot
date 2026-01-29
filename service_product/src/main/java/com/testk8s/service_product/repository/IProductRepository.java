package com.testk8s.service_product.repository;

import com.testk8s.service_product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductByCodeProduct(String codeProduct);
}
