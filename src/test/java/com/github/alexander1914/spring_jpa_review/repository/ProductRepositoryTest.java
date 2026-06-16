package com.github.alexander1914.spring_jpa_review.repository;

import com.github.alexander1914.spring_jpa_review.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        // Create a product
        Product product = new Product();
        product.setName("Product");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod() {

        //Find or retrieve on entity by ID
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //Update entity information
        product.setName("Updated product 1");
        product.setDescription("Updated product 1 description");

        //save updated entity
        productRepository.save(product);

        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();

        System.out.println(product.getId());
    }

    @Test
    void saveAllMethod() {
        // Create a product
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        // Create a product
        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(200));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));

        System.out.println(product2.toString() + "product 2");
        System.out.println(product3.toString() + "product 3");
    }

    @Test
    void findAllMethod() {

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });

        System.out.println(products.size());
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;

        productRepository.deleteById(id);

        System.out.println("Product deleted with success");
    }

}