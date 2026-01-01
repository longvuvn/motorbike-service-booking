package com.example.motorbike_be.services.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorHandler> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorHandler(
                                HttpStatus.NOT_FOUND.value(),
                                e.getMessage()
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorHandler> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorHandler(
                                HttpStatus.BAD_REQUEST.value(),
                                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
                        )
                );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorHandler> handleDataIntegrityViolationException(DataIntegrityViolationException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorHandler(
                                HttpStatus.BAD_REQUEST.value(),
                                e.getMessage()
                        )
                );
    }
}
