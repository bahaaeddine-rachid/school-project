package com.example.demo.Security.ConfigController;

import com.example.demo.Security.ConfigUserDTO.UserDTO;
import com.example.demo.Security.ConfigService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping(value = "/saveUser")
    ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @PostMapping(value="/login")
    ResponseEntity<?> login(@RequestBody UserDTO user) throws Exception {
        log.info(user.toString());

        return ResponseEntity.ok(userService.generateToken( userService.login(user)));
    }
}
