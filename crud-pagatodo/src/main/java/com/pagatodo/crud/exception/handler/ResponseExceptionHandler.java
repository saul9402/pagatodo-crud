package com.pagatodo.crud.exception.handler;

import com.pagatodo.crud.exception.model.GenericErrorResponse;
import com.pagatodo.crud.exception.types.RegisterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericErrorResponse> handleUnhandledExceptions(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().body(new GenericErrorResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()));
       // return new ResponseEntity<>(new GenericErrorResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RegisterNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> handleRegisterNotFoundException(RegisterNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(new GenericErrorResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<GenericErrorResponse> handleRegisterNotFoundException(BadCredentialsException ex, WebRequest request) {

        return new ResponseEntity<>(new GenericErrorResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

}
