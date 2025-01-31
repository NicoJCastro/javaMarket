package com.platzi.platzi_market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzi.platzi_market.domain.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    List<Product> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
