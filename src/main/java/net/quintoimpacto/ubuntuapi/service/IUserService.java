
package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;

public interface IUserService {
    User save(UserDTO userDTO);
    String updateStatus(Long id);
    User findUserByEmail(String email); // Método para encontrar usuario por email
}