package com.employee.practice.Advice;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiResponse <T>{

    private T data;

    private ApiError apiError;

    private LocalDateTime timestamp;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this();
        this.apiError = apiError;
    }

}
