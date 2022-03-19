package com.fundamentosplatzi.springboot.fundamentos.repository;


import com.fundamentosplatzi.springboot.fundamentos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u FROM User u WHERE u.email = ?1")
    Optional<User> findByUserEmail(String email);
}
