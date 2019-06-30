package com.demo.mvc.demomvc.repository;

import com.demo.mvc.demomvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.created <= :since")
    List<Product> findCreatedSince(Date since);
}
