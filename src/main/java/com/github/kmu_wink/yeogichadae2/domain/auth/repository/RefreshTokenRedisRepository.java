package com.github.kmu_wink.yeogichadae2.domain.auth.repository;

import com.github.kmu_wink.yeogichadae2.domain.auth.entity.RefreshToken;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.Optional;

public interface RefreshTokenRedisRepository extends KeyValueRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);
}
