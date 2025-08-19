package Dev.practice.demo.controller;

import Dev.practice.demo.DTO.dtoRequest.ApiResponse;
import Dev.practice.demo.DTO.Request.UserCreationRequest;
import Dev.practice.demo.DTO.Request.UserUpdateRequest;
import Dev.practice.demo.DTO.response.UserResponse;
import Dev.practice.demo.entity.User;
import Dev.practice.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
