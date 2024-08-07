package com.alimentationAkonkwa.HeadFirst.repository;

import com.alimentationAkonkwa.HeadFirst.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByName(String name);

    Optional<Category> findByName(String categoryName);

    Optional<Object> findByProductsId(Long productId);
}
