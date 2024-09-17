package az.atl.coffeshopp.controller;

import az.atl.coffeshopp.model.dto.UserDto;
import az.atl.coffeshopp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/byId/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @RequestBody UserDto userDto){
        userService.updateUser(id, userDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User updated successfully");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(OK).body("User deleted successfully");
    }
}
