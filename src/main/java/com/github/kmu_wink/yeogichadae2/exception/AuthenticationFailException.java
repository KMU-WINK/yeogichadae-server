package com.github.kmu_wink.yeogichadae2.exception;

import com.github.kmu_wink.yeogichadae2.api.ApiException;
import org.springframework.http.HttpStatus;

public class AuthenticationFailException extends ApiException {
    public AuthenticationFailException() {

        super(HttpStatus.UNAUTHORIZED, "인증에 실패하였습니다.");
    }
}
