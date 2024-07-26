package net.quintoimpacto.ubuntuapi.service;

import java.util.Optional;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;

public interface IUserService {
    User save(UserDTO userDTO);
    String updateStatus(Long id);
    Optional<User> findByEmail(String email);
}
