package com.sparta.springauth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor //자동으로 기본 생성자 생성
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)    // 타입 이름 그대로를 db에 저장
    private UserRoleEnum role;

    public User(String username, String password, String email, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    /** 엔티티 : db에서 row 당    객체 하나 ( 엔티티는 빈에 등록하지 않는다! )
     * id | username | email
     * 1  | robbie   | r@a.com
     * 2  | tom      | t@a.com
     */
}