package com.maxle.cookBookPlus.repositories;

import com.maxle.cookBookPlus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
