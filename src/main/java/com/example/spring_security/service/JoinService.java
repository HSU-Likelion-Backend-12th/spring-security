package com.example.spring_security.service;

import com.example.spring_security.dto.JoinDTO;
import com.example.spring_security.entity.UserEntity;
import com.example.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        // 회원가입 로직 작성
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        if (isUser) {
            return;
        }

        // 존재하지 않는 경우에 한해 회원가입 허용
        // 저장할 사용자 생성
        UserEntity userEntity = UserEntity.builder()
                .username(joinDTO.getUsername())
                .password(passwordEncoder.encode(joinDTO.getPassword()))
                .role("ROLE_ADMIN")
                .build();

        // 데이터베이스에 저장
        userRepository.save(userEntity);
    }
}
