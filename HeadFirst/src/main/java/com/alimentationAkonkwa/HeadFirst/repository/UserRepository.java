package com.alimentationAkonkwa.HeadFirst.repository;

import com.alimentationAkonkwa.HeadFirst.dto.UserDto;
import com.alimentationAkonkwa.HeadFirst.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    Optional<Object> findByEmail(String email);
    UserDto findByName(String username);
}
