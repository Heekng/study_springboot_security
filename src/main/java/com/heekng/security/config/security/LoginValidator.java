package com.heekng.security.config.security;

import com.heekng.security.domain.Authority;
import com.heekng.security.domain.Member;
import com.heekng.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginValidator implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        List<Member> findMembers = memberRepository.findByLoginId(loginId);

        if (findMembers.isEmpty()) {
            return null;
        }

        String password = findMembers.get(0).getPassword();
        Authority authority = findMembers.get(0).getAuthority();

        return User.builder()
                .username(loginId)
                .password(password)
                .roles(authority.name())
                .build();
    }
}
