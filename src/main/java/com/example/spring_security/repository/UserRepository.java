package com.example.spring_security.repository;

import com.example.spring_security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    // 해당하는 회원이 존재하는지 확인
    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
