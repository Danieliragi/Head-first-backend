package com.alimentationAkonkwa.HeadFirst.repository;

import com.alimentationAkonkwa.HeadFirst.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
