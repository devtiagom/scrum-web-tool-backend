package com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller;

import com.github.devtiagom.scrumwebtool.domain.user.UserService;
import com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.request.UserRequestSaveDTO;
import com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.response.UserResponseDTO;
import com.github.devtiagom.scrumwebtool.domain.user.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> index() {
        List<UserResponseDTO> users = this.userService
                .getAllUsers()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> store(@RequestBody UserRequestSaveDTO userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserResponseDTO(this.userService.saveNewUser(userDto)));
    }
}
