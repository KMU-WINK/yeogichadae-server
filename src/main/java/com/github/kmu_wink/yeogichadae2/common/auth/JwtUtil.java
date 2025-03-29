package com.github.kmu_wink.yeogichadae2.common.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.github.kmu_wink.yeogichadae2.domain.auth.entity.RefreshToken;
import com.github.kmu_wink.yeogichadae2.domain.auth.repository.RefreshTokenRedisRepository;
import com.github.kmu_wink.yeogichadae2.domain.user.entity.User;
import com.github.kmu_wink.yeogichadae2.common.property.JwtProperty;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperty jwtProperty;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;

    private Algorithm algorithm;

    @PostConstruct
    public void init() {

        algorithm = Algorithm.HMAC256(jwtProperty.getKey());
    }

    public String generateAccessToken(User user) {

        return generateAccessToken(user.getId());
    }

    public String generateAccessToken(long userId) {

        return JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(jwtProperty.getAccessTokenExpirationHours() * 3600))
                .withClaim("id", userId)
                .sign(algorithm);
    }

    public String generateRefreshToken(User user) {
        return generateRefreshToken(user.getId());
    }

    public String generateRefreshToken(long userId) {
        String token = JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(jwtProperty.getRefreshTokenExpirationHours() * 3600))
                .sign(algorithm);

        RefreshToken refreshToken = RefreshToken.builder()
                .userId(userId)
                .token(token)
                .ttl(jwtProperty.getRefreshTokenExpirationHours()*3600)
                .build();

        refreshTokenRedisRepository.save(refreshToken);

        return token;
    }

    public long extractToken(String token) {

        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getClaim("id")
                .asLong();
    }

    public boolean validateToken(String token) throws TokenExpiredException {

        if (Objects.isNull(token)) {

            return false;
        }

        JWT.require(algorithm).build().verify(token);

        return true;
    }
}
