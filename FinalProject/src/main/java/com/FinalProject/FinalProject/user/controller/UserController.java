package com.FinalProject.FinalProject.user.controller;

import com.FinalProject.FinalProject.general.response.RestResponse;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(tags = "Users")
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        UserDto userDto = userService.save(userSaveRequestDto);

        return ResponseEntity.ok(RestResponse.success(userDto));
    }
}
