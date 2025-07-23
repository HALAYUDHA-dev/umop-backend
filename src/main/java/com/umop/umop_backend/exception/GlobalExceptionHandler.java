package com.umop.umop_backend.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handler(Exception ex, HttpServletRequest request) {
        ApiError error = ApiError.builder().status(HttpStatus.BAD_REQUEST.value()).error("Bad Request")
                .message(ex.getMessage()).path(request.getRequestURI()).timestamp(LocalDateTime.now()).build();

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
