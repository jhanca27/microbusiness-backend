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

    @Override
    public User save(UserDTO userDTO) {
        User user = UserMapper.toUserEntity(userDTO);
        if (user.getRole() == null) {
            user.setRole("ADMIN");
        }
        return userRepository.save(user);
    }

    @Override
    public String updateStatus(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        user.setDeleted(!user.isDeleted());
        userRepository.save(user);
        return "User status updated";
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
