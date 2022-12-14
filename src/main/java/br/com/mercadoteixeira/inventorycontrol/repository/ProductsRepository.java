package br.com.mercadoteixeira.inventorycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadoteixeira.inventorycontrol.model.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
    
}
