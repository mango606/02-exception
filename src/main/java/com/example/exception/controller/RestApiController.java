package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "")
    public void hello() {
//        throw new RuntimeException("runtime exception");    // 500 에러
        var list = List.of("hello");
        var element = list.get(1);  // OutOfIndex 에러

        log.info("element : {}", element);
        // try-catch로 하나하나 묶어주는 것은 비효율적임. -> ExceptionHandler로 해결
    }
}
