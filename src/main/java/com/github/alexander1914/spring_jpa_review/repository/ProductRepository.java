package com.github.alexander1914.spring_jpa_review.repository;

import com.github.alexander1914.spring_jpa_review.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
