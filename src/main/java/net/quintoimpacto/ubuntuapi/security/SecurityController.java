package net.quintoimpacto.ubuntuapi.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class SecurityController {

    
    @GetMapping("/user")
    public String user() {
        return "Hello world";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello world Admin";
    }

}
