package com.FinalProject.FinalProject.security.controller;

import com.FinalProject.FinalProject.general.response.RestResponse;
import com.FinalProject.FinalProject.security.dto.SecLoginRequestDto;
import com.FinalProject.FinalProject.security.service.AuthenticationService;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam @Valid String userName, @RequestParam @Valid String password){
        SecLoginRequestDto secLoginRequestDto = new SecLoginRequestDto();
        secLoginRequestDto.setUserName(userName);
        secLoginRequestDto.setPassword(password);
        String token = authenticationService.login(secLoginRequestDto);

        return ResponseEntity.ok(RestResponse.success(token));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserSaveRequestDto userSaveRequestDto){

        UserDto userDto =authenticationService.register(userSaveRequestDto);

        return ResponseEntity.ok(RestResponse.success(userDto));
    }
}