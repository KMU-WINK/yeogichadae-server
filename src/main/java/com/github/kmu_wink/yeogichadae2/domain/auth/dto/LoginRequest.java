package com.github.kmu_wink.yeogichadae2.domain.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank
        String token

) {
}
