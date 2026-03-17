package com.employee.practice.Advice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
@Builder
public class ApiError {
    private Integer code;
    private HttpStatus status;
    private String message;
}
