package Dev.practice.demo.controller;


import Dev.practice.demo.dto.Request.UserCreationRequest;
import Dev.practice.demo.dto.Request.UserUpdateRequest;
import Dev.practice.demo.dto.response.ApiResponse;
import Dev.practice.demo.dto.response.UserResponse;
import Dev.practice.demo.entity.User;
import Dev.practice.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController  {
    @Autowired

    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User>  response = new ApiResponse<>();


        response.setResult(userService.createUser(request));
        return response;
    }

    @GetMapping
    @Operation(summary = "Get user profile",
            security = { @SecurityRequirement(name = "bearerAuth") })
    List<User> getAllUsers() {
        return userService.getUser();
    }



    @GetMapping("/{userId}")
    UserResponse getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
