package com.maxle.cookBookPlus.repositories;

import com.maxle.cookBookPlus.models.entities.ChefUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ChefUser, Long> {
   ChefUser findByUsername(String username);
}
