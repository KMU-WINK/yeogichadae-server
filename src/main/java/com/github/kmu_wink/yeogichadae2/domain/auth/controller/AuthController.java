package com.github.kmu_wink.yeogichadae2.domain.auth.controller;

import com.github.kmu_wink.yeogichadae2.common.api.ApiResponse;
import com.github.kmu_wink.yeogichadae2.common.auth.AuthGuard;
import com.github.kmu_wink.yeogichadae2.domain.auth.dto.LoginRequest;
import com.github.kmu_wink.yeogichadae2.domain.auth.dto.LoginResponse;
import com.github.kmu_wink.yeogichadae2.domain.auth.dto.MyInfoResponse;
import com.github.kmu_wink.yeogichadae2.domain.auth.service.AuthService;
import com.github.kmu_wink.yeogichadae2.domain.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
@Tag(name = "Auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ApiResponse.ok(authService.login(request));
    }

    @PostMapping("/refresh-token")
    public ApiResponse<LoginResponse> refreshToken(@RequestBody @Valid LoginRequest request) {
        return ApiResponse.ok(authService.refreshToken(request));
    }

    @GetMapping("/me")
    @AuthGuard
    public ApiResponse<MyInfoResponse> myInfo(@AuthenticationPrincipal User user) {
        return ApiResponse.ok(authService.myInfo(user));
    }
}
