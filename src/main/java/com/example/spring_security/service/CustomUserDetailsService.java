package com.example.spring_security.service;

import com.example.spring_security.dto.CustomUserDetails;
import com.example.spring_security.entity.UserEntity;
import com.example.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity
                = userRepository.findByUsername(username);

        if (optionalUserEntity.isPresent()) {

            UserEntity userEntity = optionalUserEntity.get();
            // 조회된 사용자 정보를 바탕으로 UserDetails 객체 생성
            return new CustomUserDetails(userEntity);
        }

        return null;
    }
}
