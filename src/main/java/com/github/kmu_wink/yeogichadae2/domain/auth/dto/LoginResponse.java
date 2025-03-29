package com.github.kmu_wink.yeogichadae2.domain.auth.dto;

import lombok.Builder;

@Builder
public record LoginResponse (

    String accessToken,
    String refreshToken
) {
}
