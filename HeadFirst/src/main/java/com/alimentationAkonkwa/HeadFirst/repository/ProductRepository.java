package com.alimentationAkonkwa.HeadFirst.repository;

import com.alimentationAkonkwa.HeadFirst.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByName(String name);

    Optional<Product> findByName(String product);

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM produits p JOIN p.categories c WHERE c.name = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);


    List<Product> findByPriceBetween(double minPrice, double maxPrice);

}
