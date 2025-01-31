package com.platzi.platzi_market.persistence;

import com.platzi.platzi_market.persistence.crud.ProductoCrudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzi.platzi_market.persistence.entity.Producto;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    // Query Methods are methods that are automatically implemented by Spring Data JPA

    public List<Producto> getByCategory(int idCategory) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
    }

    public Optional<List<Producto>> getScarceProducts(int quantity) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    }

    // Interactuar con la BD metodos de guardar, eliminar, etc

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
