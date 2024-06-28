package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.repository.IUserRepository;
import net.quintoimpacto.ubuntuapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
