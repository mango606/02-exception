package com.example.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice   // REST API가 사용하는 곳에 예외 발생을 감지함.
public class ReatApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler ", e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = { IndexOutOfBoundsException.class })
    public ResponseEntity outOfBoundsException(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundsExceptionHandler ", e);
        return ResponseEntity.status(200).build();
    }
}
