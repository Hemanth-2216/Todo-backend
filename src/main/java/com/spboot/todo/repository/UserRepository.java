package com.spboot.todo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spboot.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
