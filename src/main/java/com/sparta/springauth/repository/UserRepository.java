package com.sparta.springauth.repository;

import com.sparta.springauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA가 자동으로:
 * UserRepository 구현체 생성
 * → @Repository Bean으로 등록, 인터페이스는 @Repository 없어도 된다!
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * <엔티티, PK 타입>
     save()
     findById()
     findAll()
     delete()
     count()
     existsById()
     */

    Optional<User> findByUsername(String username); //  있으면 User 반환, 없으면 null 반환
    Optional<User> findByEmail(String email);
}
