package com.github.kmu_wink.yeogichadae2.common.exception;

import com.github.kmu_wink.yeogichadae2.common.api.ApiException;
import org.springframework.http.HttpStatus;

public class KakaoAccessTokenException extends ApiException {

    public KakaoAccessTokenException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
