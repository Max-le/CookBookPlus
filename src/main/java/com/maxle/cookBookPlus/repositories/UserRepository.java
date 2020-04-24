package com.maxle.cookBookPlus.repositories;

import com.maxle.cookBookPlus.models.entities.chefUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<chefUser, Long> {
   chefUser findByUsername(String username);
}
