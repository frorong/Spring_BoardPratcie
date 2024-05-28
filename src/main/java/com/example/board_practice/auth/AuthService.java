package com.example.board_practice.auth;

import com.example.board_practice.user.RequestEntity;
import com.example.board_practice.user.UserEntity;
import com.example.board_practice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    Long saveUser(RequestEntity dto) {
        UserEntity newUser = UserEntity.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build();

        userRepository.save(newUser);

        return newUser.getId();
    }

    Long checkLogin(RequestEntity dto) {
        Optional<UserEntity> targetUser = userRepository.findByEmail(dto.getEmail());

        if (targetUser.isPresent() && targetUser.get().getPassword().equals(dto.getPassword())) {
            return targetUser.get().getId();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
