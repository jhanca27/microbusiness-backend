package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessCategoryDto;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuración específica para mapear MicroBusiness a MicroBusinessDTO
        modelMapper.addMappings(new PropertyMap<MicroBusiness, MicroBusinessCategoryDto>() {
            @Override
            protected void configure() {
                // Mapea el enum Category
                map().setCategory(source.getCategory());
            }
        });

        return modelMapper;
    }
}
