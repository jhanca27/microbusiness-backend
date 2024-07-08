package net.quintoimpacto.ubuntuapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private boolean deleted;
    private String role;
}
