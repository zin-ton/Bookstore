package com.example.bookstore.repositories;

import com.example.bookstore.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByLogin(String username);
    @Query("SELECT u FROM users u WHERE u.login like ?1")
    List<Users> findByLoginBeginWith(String login);
}
