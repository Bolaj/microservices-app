package com.portfolio.productservice.repository;

import com.portfolio.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  ProductRepository extends MongoRepository<Product, String> {
}
