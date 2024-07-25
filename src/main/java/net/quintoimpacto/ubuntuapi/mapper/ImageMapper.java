package net.quintoimpacto.ubuntuapi.mapper;

import net.quintoimpacto.ubuntuapi.dto.ImageDTO;
import net.quintoimpacto.ubuntuapi.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageDTO toDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setUrl(image.getUrl());
        dto.setPublicId(image.getPublicId());
        if (image.getMicroBusiness() != null) {
            dto.setMicroBusinessId(image.getMicroBusiness().getId());
        }
        return dto;
    }

    public Image toEntity(ImageDTO dto) {
        Image image = new Image();
        image.setId(dto.getId());
        image.setUrl(dto.getUrl());
        image.setPublicId(dto.getPublicId());
        return image;
    }
}