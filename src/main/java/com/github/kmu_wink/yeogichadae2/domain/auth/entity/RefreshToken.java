package com.github.kmu_wink.yeogichadae2.domain.auth.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Builder
@RedisHash(value = "refresh_token")
public record RefreshToken (

    @Id
    Long id,

    @Indexed
    String token,

    long userId,

    @TimeToLive
    long ttl
) {
}
