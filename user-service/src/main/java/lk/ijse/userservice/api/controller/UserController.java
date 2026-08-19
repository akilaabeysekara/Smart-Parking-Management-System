package lk.ijse.userservice.api.controller;

import lk.ijse.userservice.api.response.ApiResponse;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(
            @RequestBody User user) {

        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        201,
                        "User created successfully",
                        createdUser
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(
            @PathVariable Long id) {

        User user = userService.getUserById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "User retrieved successfully",
                        user
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Users retrieved successfully",
                        users
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "User updated successfully",
                        updatedUser
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(
                new ApiResponse<>(
                        204,
                        "User deleted successfully",
                        null
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<User>> getUserByEmail(
            @PathVariable String email) {

        User user = userService.getUserByEmail(email);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "User retrieved successfully",
                        user
                )
        );
    }
}