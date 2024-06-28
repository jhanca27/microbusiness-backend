package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userEntity2userDTO(UserDTO userDTO) {
        User user = new User();
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        return user;
    }
}
