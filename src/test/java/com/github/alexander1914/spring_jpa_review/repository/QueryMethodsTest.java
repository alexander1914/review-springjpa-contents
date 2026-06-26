package com.github.alexander1914.spring_jpa_review.repository;

import com.github.alexander1914.spring_jpa_review.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {

        Product product = productRepository.findByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {

        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = productRepository.
                findByNameOrDescription("product 1", "product 1 description");

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });

        System.out.println(products.toString());
    }

    @Test
    void findByNameAndDescriptionMethod() {

        List<Product> products = productRepository.
                findByNameAndDescription("product 1", "product 1 description");

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });

        System.out.println(products.toString());
    }

    @Test
    void findDistinctByNameMethod() {

        Product product = productRepository.findDistinctByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        });
    }

}
