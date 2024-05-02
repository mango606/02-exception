package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    // localhost:8080/api/b
    @GetMapping(path = "/hello")
    public void hello() {
        throw new NumberFormatException("number format exception");
        // RestApiExceptionHandler가 나오는 이유: number format exception이 따로 지정되어 있지 않음.
    }

/*    // 조금 더 명시적으로 지정
    @ExceptionHandler(value = { NumberFormatException.class })
    public ResponseEntity numberFormatException(
        NumberFormatException e
    ){
        log.error("RestApiBController", e);

        return ResponseEntity.ok().build();
        // RestApiBController에서 예외가 Error Level로 캐치됨.
        // 이유: 여기서 ExceptionHandler로 잡으면 ControllerAdvice가 있어도 전달되지 않음.
    }*/

}
