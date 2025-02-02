package com.platzi.platzi_market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.platzi_market.domain.Purchase;
import com.platzi.platzi_market.domain.repository.PurchaseRepository;
import com.platzi.platzi_market.persistence.crud.CompraCrudRepository;
import com.platzi.platzi_market.persistence.entity.Compra;
import com.platzi.platzi_market.persistence.mapper.PurchaseMapper;

import jakarta.transaction.Transactional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
@Transactional
public Purchase save(Purchase purchase) {
    if (purchase == null) {
        throw new IllegalArgumentException("La compra no puede ser nula.");
    }

    Compra compra = mapper.toCompra(purchase);
    if (compra.getIdCompra() == null || compra.getIdCompra() == 0) {
        // Es una nueva compra, asegúrate de que el ID sea nulo o 0
        compra.setIdCompra(null);
    }

    if (compra.getProductos() != null) {
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
    }

    try {
        Compra savedCompra = compraCrudRepository.save(compra);
        return mapper.toPurchase(savedCompra);
    } catch (Exception e) {
        throw new RuntimeException("Error al guardar la compra: " + e.getMessage(), e);
    }
}

}
