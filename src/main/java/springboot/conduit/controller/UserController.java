package springboot.conduit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springboot.conduit.dto.UserDTO;
import springboot.conduit.returndto.UserReturnDTO;
import springboot.conduit.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReturnDTO createNewUser(@RequestBody UserDTO userDTO) {
        return userService.createNewUser(userDTO.getUser());
    }

}
