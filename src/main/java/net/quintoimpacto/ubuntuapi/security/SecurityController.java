package net.quintoimpacto.ubuntuapi.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/user")
    public String user() {
        return "Hello world";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello world Admin";
    }

}
