package com.sparta.springauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())           // POST 안 쓰면 없어도 되지만 일단 실습용으로
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()           // 모든 요청 허용
                )
                .formLogin(form -> form.disable())      // ✅ 기본 로그인 페이지 제거
                .httpBasic(basic -> basic.disable());   // ✅ 브라우저 기본 인증 팝업도 제거

        return http.build();
    }
}
