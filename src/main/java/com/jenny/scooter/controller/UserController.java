package com.jenny.scooter.controller;

import com.jenny.scooter.model.UserCreateRequestDto;
import com.jenny.scooter.entity.User;
import com.jenny.scooter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="User API", description = "사용자 API")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@Parameter(description = "User 생성 요청 DTO") @RequestBody UserCreateRequestDto userCreateRequestDto) {
        return userService.saveUser(userCreateRequestDto);
    }

    @GetMapping("/{id}")
    public User findUserById(@Parameter(description = "User의 no") @PathVariable(name = "id") Long userId) {

        return userService.getUserById(userId);
    }

    @GetMapping
    @Operation(summary = "User 계정 조회", description = "User 계정을 username(아이디)로 조회합니다.")
    public User findUserByUsername(@Parameter(description = "User 아이디") @RequestParam(name = "username") String userUsername) {

        return userService.getUserByUsername(userUsername);
    }


}
