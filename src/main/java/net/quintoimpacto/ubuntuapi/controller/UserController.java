package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        String response = userService.updateStatus(id);
        return ResponseEntity.ok(response);
    }
}
