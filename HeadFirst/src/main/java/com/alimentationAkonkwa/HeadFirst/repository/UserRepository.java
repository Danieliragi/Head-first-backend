package com.alimentationAkonkwa.HeadFirst.repository;

import com.alimentationAkonkwa.HeadFirst.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
