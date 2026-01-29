package com.testk8s.service_product.service;

import com.testk8s.service_product.mapper.IProductMapper;
import com.testk8s.service_product.repository.IProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl {
    IProductRepository productRepo;

    IProductMapper productMapper;

    public model.Product findByCodeProduct(String codeProduct) {
        return productMapper.toProduct(productRepo.findProductByCodeProduct(codeProduct));
    }

    public List<model.Product> findAll() {
        return productRepo.findAll().stream().map(productMapper::toProduct).toList();
    }
}
