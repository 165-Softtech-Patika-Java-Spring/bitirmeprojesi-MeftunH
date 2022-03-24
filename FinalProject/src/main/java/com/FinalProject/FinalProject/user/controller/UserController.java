package com.FinalProject.FinalProject.user.controller;

import com.FinalProject.FinalProject.general.response.RestResponse;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
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
                                    ),
                                    examples = {
                                            @ExampleObject(
                                                    name = "new foreign user",
                                                    summary = "New Foreign user Example",
                                                    description = "Complete request with all available fields for foreign user",
                                                    value = "{\n" +
                                                            "  \"name\": \"john\",\n" +
                                                            "  \"surname\": \"smith\",\n" +
                                                            "  \"userName\": \"JohnUserName\"\n" +
                                                            "  \"password\": \"J.s_1234\"\n" +
                                                            "}"
                                            ),
                                            @ExampleObject(
                                                    name = "new user",
                                                    summary = "New user Example",
                                                    description = "Complete request with all available fields",
                                                    value = "{\n" +
                                                            "  \"name\": \"john\",\n" +
                                                            "  \"surname\": \"doe\",\n" +
                                                            "  \"userName\": \"JohnUserName\"\n" +
                                                            "  \"password\": \"John123\"\n" +
                                                            "}"
                                            )
                                    }
                            ),
                    }
            )
    )
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        UserDto userDto = userService.save(userSaveRequestDto);

        return ResponseEntity.ok(RestResponse.success(userDto));
    }
}
