package com.FinalProject.FinalProject.security.controller;

import com.FinalProject.FinalProject.general.response.RestResponse;
import com.FinalProject.FinalProject.security.dto.SecLoginRequestDto;
import com.FinalProject.FinalProject.security.service.AuthenticationService;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto){

        String token = authenticationService.login(secLoginRequestDto);

        return ResponseEntity.ok(RestResponse.success(token));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserSaveRequestDto userSaveRequestDto){

        UserDto cusCustomerDto =authenticationService.register(userSaveRequestDto);

        return ResponseEntity.ok(RestResponse.success(cusCustomerDto));
    }
}