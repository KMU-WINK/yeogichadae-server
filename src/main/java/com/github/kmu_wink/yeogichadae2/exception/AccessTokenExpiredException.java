package com.github.kmu_wink.yeogichadae2.exception;

import com.github.kmu_wink.yeogichadae2.api.ApiException;
import org.springframework.http.HttpStatus;

public class AccessTokenExpiredException extends ApiException {
    public AccessTokenExpiredException() {

        super(HttpStatus.UNAUTHORIZED, "액세스 토큰이 만료되었습니다.");
    }
}
