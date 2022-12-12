package br.com.mercadoteixeira.inventorycontrol.repository;

import br.com.mercadoteixeira.inventorycontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

//will be responsible for integrating our application with the Users table in the database
