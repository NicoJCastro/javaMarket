package com.platzi.platzi_market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.platzi.platzi_market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Aquí no se necesita implementar nada, Spring Data JPA se encarga de hacerlo por nosotros
    // Solo se necesita extender de CrudRepository y pasarle el tipo de dato que se va a manejar y el tipo de dato de la llave primaria
    // En este caso, Producto y Integer

    //Query Methods
    
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
