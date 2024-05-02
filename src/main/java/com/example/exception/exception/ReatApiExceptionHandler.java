package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.exception.controller")
// @RestControllerAdvice(basePackageClasses = { RestApiController.class, RestApiBController.class }
public class ReatApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler ", e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBoundsException(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundsExceptionHandler ", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Api> noSuchElement(   // Api -> ResponseEntity<Api>로 내려서 "200 OK"가 발생하는 문제를 해결.
                                                NoSuchElementException e
    ) {
        log.error("", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response)
                ;
    }
}
