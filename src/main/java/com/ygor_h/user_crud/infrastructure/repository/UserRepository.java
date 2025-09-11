package com.ygor_h.user_crud.infrastructure.repository;

import com.ygor_h.user_crud.infrastructure.entitys.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCpf(String cpf);

    @Transactional // If an error occurs, you cannot delete the email
    void deleteByCpf(String cpf);
}
