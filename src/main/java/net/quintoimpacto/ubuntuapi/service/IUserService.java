package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;

import java.util.Optional;

public interface IUserService {
    public User save(UserDTO userDTO);
    public String updateStatus(Long id);
}
