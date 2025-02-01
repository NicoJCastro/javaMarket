package com.platzi.platzi_market.persistence;

import com.platzi.platzi_market.domain.Product;
import com.platzi.platzi_market.domain.repository.ProductRepository;
import com.platzi.platzi_market.persistence.crud.ProductoCrudRepository;
import java.util.List;
import java.util.Optional;
import com.platzi.platzi_market.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.platzi_market.persistence.entity.Producto;

@Repository
public class ProductoRepository implements ProductRepository {
    // Debemos crear los objetos antes que se van a utilizar 
    // AutoWired es para que Spring se encargue de crear la instancia de la clase. Tiene que ser un objeto que Spring conozca
    // Atributos
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // Query Methods are methods that are automatically implemented by Spring Data JPA
    @Override
    public Optional<List<Product>> getByCategory(int idCategory) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods-> mapper.toProducts(prods));
    }

    // Interactuar con la BD metodos de guardar, eliminar, etc
   
    @Override
    public Optional<Product> getProduct(int idProducto) {
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }   

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
