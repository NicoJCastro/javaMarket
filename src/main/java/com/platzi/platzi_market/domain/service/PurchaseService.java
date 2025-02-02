package com.platzi.platzi_market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.platzi.platzi_market.domain.Purchase;
import com.platzi.platzi_market.domain.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    
    public Object getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

   public Purchase save(Purchase purchase) {
        if (purchase.getPurchaseId() != 0) {
            throw new IllegalArgumentException("Invalid purchase");
        }

        try {
            return purchaseRepository.save(purchase);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Manejar la excepción de concurrencia optimista
            throw new RuntimeException("Error de concurrencia. La compra ha sido modificada por otro proceso. Intente nuevamente.");
        } catch (DataAccessException e) {
            // Manejar otras excepciones de acceso a datos
            throw new RuntimeException("Error de acceso a datos al intentar guardar la compra.", e);
        }
    }
   
}
