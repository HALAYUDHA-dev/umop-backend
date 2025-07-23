package com.umop.umop_backend.role.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.umop.umop_backend.exception.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RoleNotFoundHandler {

    @ExceptionHandler(RoleNotFound.class)
    ResponseEntity<ApiError> roleNotFoundHandler(RuntimeException ex, HttpServletRequest request) {
        ApiError error = ApiError.builder().error("Role Not Found").message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value()).path(request.getRequestURI()).timestamp(LocalDateTime.now())
                .build();

                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
