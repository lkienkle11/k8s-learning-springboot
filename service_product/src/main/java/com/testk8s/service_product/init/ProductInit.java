package com.testk8s.service_product.init;

import com.testk8s.service_product.entity.Product;
import com.testk8s.service_product.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductInit implements CommandLineRunner {

    private final IProductRepository productRepository;

    @Override
    public void run(String... args) {
        long count = productRepository.count();
        if (count >= 20) {
            log.info("Products already initialized (count: {}), skipping initialization.", count);
            return;
        }

        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            String codeProduct = "product" + i;

            if (productRepository.findProductByCodeProduct(codeProduct) == null) {
                Product product = Product.builder()
                        .codeProduct(codeProduct)
                        .name("Product Name " + i)
                        .description("Description for product " + i)
                        .price(10.0 + (100.0 - 10.0) * random.nextDouble()) // Random price between 10 and 100
                        .category("Category " + (random.nextInt(5) + 1))
                        .brand("Brand " + (random.nextInt(5) + 1))
                        .stockQuantity(random.nextInt(100))
                        .sku("SKU-" + codeProduct.toUpperCase())
                        .build();
                productRepository.save(product);
                log.info("Initialized product: {}", codeProduct);
            }
        }
    }
}
