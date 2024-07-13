package com.javid.order.exception;

import lombok.Getter;

@Getter
public class CustomFeignException extends RuntimeException {
    private final Integer statusCode;

    public CustomFeignException(int statusCode, String errorMsg) {
        super(errorMsg);
        this.statusCode = statusCode;
    }
}
