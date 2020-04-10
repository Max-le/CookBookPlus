package com.maxle.cookBookPlus.repositories;

import com.maxle.cookBookPlus.entities.WebResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebResourceRepository extends JpaRepository<WebResource, Long> {
}
