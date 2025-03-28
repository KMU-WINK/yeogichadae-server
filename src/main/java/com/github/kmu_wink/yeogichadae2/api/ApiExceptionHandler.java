package com.github.kmu_wink.yeogichadae2.api;

import com.github.kmu_wink.yeogichadae2.exception.AccessTokenExpiredException;
import com.github.kmu_wink.yeogichadae2.exception.AuthenticationFailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(AccessTokenExpiredException.class)
    public ApiResponse<?> accessTokenExpiredException(AccessTokenExpiredException ex) {
        return ApiResponse.error(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(AuthenticationFailException.class)
    public ApiResponse<?> authenticationFailException(AccessTokenExpiredException ex) {
        return ApiResponse.error(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    public ApiResponse<?> apiException(ApiException ex) {
        return ApiResponse.error(ex);
    }
}
