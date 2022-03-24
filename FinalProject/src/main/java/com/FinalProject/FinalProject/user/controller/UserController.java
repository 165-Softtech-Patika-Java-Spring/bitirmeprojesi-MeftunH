package com.FinalProject.FinalProject.user.controller;

import com.FinalProject.FinalProject.general.response.RestResponse;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.dto.UserUpdateRequestDto;
import com.FinalProject.FinalProject.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(
            tags = "User Controller",
            description = "Creates new user",
            summary = "creates new user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Users",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = UserSaveRequestDto.class
                                    )

                            ),
                    }
            )
    )
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        UserDto userDto = userService.save(userSaveRequestDto);

        return ResponseEntity.ok(RestResponse.success(userDto));
    }
    @Operation(tags = "User Controller")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        userService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }
    @Operation(tags = "User Controller")
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserDto userDto = userService.update(id,userUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.success(userDto));
    }
}
