package com.alimentationAkonkwa.HeadFirst.controller;

import com.alimentationAkonkwa.HeadFirst.dto.UserDto;
import com.alimentationAkonkwa.HeadFirst.models.User;
import com.alimentationAkonkwa.HeadFirst.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/clients")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllClients() {
        List<UserDto> users = userService.getAllClients().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse<>(users));
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getClientById(@PathVariable("id") Long id) {
        User user = userService.getClientById(id);
        return ResponseEntity.ok(new ApiResponse<>(UserDto.fromEntity(user)));
    }

    @PostMapping("/clients")
    public ResponseEntity<ApiResponse<UserDto>> createClient(@Valid @RequestBody UserDto userDto) {
        User user = userService.createClient(userDto.toEntity());
        return new ResponseEntity<>(new ApiResponse<>(UserDto.fromEntity(user)), HttpStatus.CREATED);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ApiResponse<String>> updateClient(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        boolean isUpdated = userService.updateClientById(id, userDto.toEntity());
        if (isUpdated) {
            return ResponseEntity.ok(new ApiResponse<>("User updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("User not found"));
        }
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<ApiResponse<String>> deleteClientById(@PathVariable Long id) {
        boolean isDeleted = userService.deleteClientById(id);
        if (isDeleted) {
            return ResponseEntity.ok(new ApiResponse<>("User deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("User not found"));
        }
    }
}
