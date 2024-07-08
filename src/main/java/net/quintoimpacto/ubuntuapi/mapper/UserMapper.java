package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.UserDTO;
import net.quintoimpacto.ubuntuapi.entity.User;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

@Component
public class UserMapper {
    public static User toUserEntity (UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<UserDTO, User> propertyMapper = modelMapper.createTypeMap(UserDTO.class, User.class);
        propertyMapper.addMapping(UserDTO::getFirst_name, User::setFirst_name);
        propertyMapper.addMapping(UserDTO::getLast_name, User::setLast_name);
        propertyMapper.addMapping(UserDTO::getEmail, User::setEmail);
        propertyMapper.addMapping(UserDTO::getPhone, User::setPhone);
        return propertyMapper.map(userDTO);
    }
}
