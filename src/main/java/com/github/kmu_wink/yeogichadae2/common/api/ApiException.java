package com.github.kmu_wink.yeogichadae2.common.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException{

    private final HttpStatus status;
    private final String message;
}
