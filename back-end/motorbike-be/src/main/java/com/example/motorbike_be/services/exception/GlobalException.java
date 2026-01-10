package com.example.motorbike_be.services.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorHandler> handleNoResourceFoundException(NoResourceFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorHandler(
                        HttpStatus.NOT_FOUND.value(),
                        "API không tồn tại"
                )
        );
    }
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorHandler> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorHandler(
                                HttpStatus.BAD_REQUEST.value(),
                                e.getMessage()
                        )
                );
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorHandler> handleNumberFormatException(NumberFormatException e){
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
