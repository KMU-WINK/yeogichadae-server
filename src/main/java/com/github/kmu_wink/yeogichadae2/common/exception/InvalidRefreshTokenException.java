package com.github.kmu_wink.yeogichadae2.common.exception;

import com.github.kmu_wink.yeogichadae2.common.api.ApiException;
import org.springframework.http.HttpStatus;

public class InvalidRefreshTokenException extends ApiException {

    public InvalidRefreshTokenException() {
        super(HttpStatus.BAD_REQUEST, "유효하지 않은 리프레시 토큰입니다.");
    }
}
