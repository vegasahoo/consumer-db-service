package com.satya.dbservice.repository;

import com.satya.dbservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findByCode(String code);
    public List<Product> findByColor(String color);
}
