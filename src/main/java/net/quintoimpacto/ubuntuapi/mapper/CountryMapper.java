package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.CountryDTO;
import net.quintoimpacto.ubuntuapi.entity.Country;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public static CountryDTO toCountryDTO (Country country) {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Country, CountryDTO> propertyMapper = modelMapper.createTypeMap(Country.class, CountryDTO.class);
        propertyMapper.addMapping(Country::getId, CountryDTO::setId);
        propertyMapper.addMapping(Country::getName, CountryDTO::setName);
        return propertyMapper.map(country);
    }
}
