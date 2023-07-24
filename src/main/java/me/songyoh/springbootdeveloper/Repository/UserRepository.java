package me.songyoh.springbootdeveloper.Repository;

import me.songyoh.springbootdeveloper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email로 사용자 정보를 가져옴
}
