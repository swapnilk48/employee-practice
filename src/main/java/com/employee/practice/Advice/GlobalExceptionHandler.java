package com.employee.practice.Advice;

import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Exception.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNoSuchElementException(ResourceNotFoundException e){
        ApiError apiError = ApiError.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build();

        return buildErrorResponse(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> errors = e
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();
        ApiError apiError = ApiError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .message(errors.toString())
                .build();

        return buildErrorResponse(apiError);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<?>> handleDataIntegrity(DataIntegrityViolationException ex) {

        String message = "Duplicate value";

        Throwable cause = ex.getCause();

        if (cause instanceof ConstraintViolationException cve) {
            String constraint = cve.getConstraintName();
            message = mapConstraintToMessage(constraint);
        }

        ApiError apiError = ApiError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .message(message)
                .build();

        return buildErrorResponse(apiError);
    }

    private static final Map<String, String> CONSTRAINT_MAP = Map.of(
            "email_constraint", "Email already exists",
            "email_linkedin_constraint", "Email + LinkedIn already exists"
    );

    private String mapConstraintToMessage(String constraint) {
        return CONSTRAINT_MAP.getOrDefault(constraint, "Duplicate value");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericException(Exception e){
        ApiError apiError = ApiError.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();

        return buildErrorResponse(apiError);
    }

    public ResponseEntity<ApiResponse<?>> buildErrorResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}
