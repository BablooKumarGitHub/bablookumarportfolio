package com.udayam.bablookumar.advice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udayam.bablookumar.exception.UnauthorizedException;
import com.udayam.bablookumar.util.Response;

@ControllerAdvice
public class UnauthorizedExceptionHandler {
    
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<HashMap<String, Object>> handleUnauthorizedException(UnauthorizedException e) {
        return Response.unauthorized();
    }
}
