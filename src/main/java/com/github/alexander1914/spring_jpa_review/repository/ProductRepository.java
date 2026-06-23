package com.github.alexander1914.spring_jpa_review.repository;

import com.github.alexander1914.spring_jpa_review.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    Optional<Product> findById(Long id);

}
