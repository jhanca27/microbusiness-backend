package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.CategoryDTO;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom converter for Category enum to CategoryDTO
        Converter<Category, CategoryDTO> categoryToDtoConverter = new Converter<Category, CategoryDTO>() {
            @Override
            public CategoryDTO convert(MappingContext<Category, CategoryDTO> context) {
                Category source = context.getSource();
                return new CategoryDTO(source.name(), source.getDescription());
            }
        };

        // Add the custom converter
        modelMapper.addConverter(categoryToDtoConverter);

        return modelMapper;
    }
}
