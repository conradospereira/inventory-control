package br.com.mercadoteixeira.inventorycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadoteixeira.inventorycontrol.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
    
}
