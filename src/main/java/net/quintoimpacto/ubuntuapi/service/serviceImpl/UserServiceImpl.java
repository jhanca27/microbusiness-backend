package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.mapper.UserMapper;
import net.quintoimpacto.ubuntuapi.repository.IUserRepository;
import net.quintoimpacto.ubuntuapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(UserDTO userDTO) {
        User user = userMapper.userEntity2userDTO(userDTO);
        if (user.getRole() == null) {
            user.setRole("admin");
        }
        return userRepository.save(user);
    }
}
