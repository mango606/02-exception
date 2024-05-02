package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    // 데이터베이스가 없으므로 임의로 User 선언
    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("유관순")
                    .build()
    );

/*    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser() {
        var user = new UserResponse();
        user.setId("1");
        user.setAge(10);
        user.setName("홍길동");
    }*/

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ) {
        if (true) {
            throw new RuntimeException("message");
        }

        var user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId)
                )
                .findFirst()
                .get(); // null이 나오지 않게 하려면 핕터를 걸어야 함.


        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))  // int로 내려오는 HttpStatus 코드를 문자열 코드로 바꿈. 예) "200"
                .resultMessage(HttpStatus.OK.name())    // 예) "OK" -> 없는 데이터를 입력하면 body의 내용이 아무것도 없음.
                .data(user)
                .build();

        return response;
    }


}