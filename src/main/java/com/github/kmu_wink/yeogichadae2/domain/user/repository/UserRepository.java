package com.github.kmu_wink.yeogichadae2.domain.user.repository;

import com.github.kmu_wink.yeogichadae2.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByKakao(long kakao);
}
