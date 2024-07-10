package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;
import net.quintoimpacto.ubuntuapi.entity.Province;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class ProvinceMapper {
    public static ProvinceDTO toProvinceDTO (Province province) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Province, ProvinceDTO> propertyMapper = modelMapper.createTypeMap(Province.class, ProvinceDTO.class);
        propertyMapper.addMapping(Province::getId, ProvinceDTO::setId);
        propertyMapper.addMapping(Province::getName, ProvinceDTO::setName);
        return propertyMapper.map(province);
    }
}
