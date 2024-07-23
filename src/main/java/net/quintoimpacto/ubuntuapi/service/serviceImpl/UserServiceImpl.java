package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
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
            user.setRole("admin");
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

    public User findUserByEmailOrCreateIt(GoogleIdToken.Payload payload) {
        String email = payload.getEmail();
        User user = userRepository.findByEmail(email);

        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setFirst_name((String) payload.get("given_name"));
            user.setLast_name((String) payload.get("family_name"));
            user.setRole("USER");
            userRepository.save(user);
        }
        return user;
    }
}
