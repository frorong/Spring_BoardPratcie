package com.example.board_practice.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<SigninRequestEntity, Long> {

}