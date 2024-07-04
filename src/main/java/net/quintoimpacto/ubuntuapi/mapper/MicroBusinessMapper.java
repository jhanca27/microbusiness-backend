package net.quintoimpacto.ubuntuapi.mapper;

import org.springframework.stereotype.Component;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;

@Component
public class MicroBusinessMapper {
    public static MicroBusiness toMicroBusinessEntity(MicroBusinessDTO microBusinessDTO){
        MicroBusiness microBusinessEntity = MicroBusiness
                                                    .builder()
                                                    .id(microBusinessDTO.getId())
                                                    .name(microBusinessDTO.getName())
                                                    .description(microBusinessDTO.getDescription())
                                                    .moreInformation(microBusinessDTO.getMoreInformation())
                                                    .deleted(microBusinessDTO.isDeleted())
                                                    .managed(microBusinessDTO.isManaged())
                                                    .category(microBusinessDTO.getCategory())
                                                    .user(microBusinessDTO.getUser())
                                                    .country(microBusinessDTO.getCountry())
                                                    .province(microBusinessDTO.getProvince())
                                                    .build();
        return microBusinessEntity;
    }

    public static MicroBusinessDTO toMicroBusinessDTO(MicroBusiness microBusiness){
        MicroBusinessDTO microBusinessDTO = MicroBusinessDTO.builder()
                                                            .id(microBusiness.getId())
                                                            .name(microBusiness.getName())
                                                            .description(microBusiness.getDescription())
                                                            .moreInformation(microBusiness.getMoreInformation())
                                                            .deleted(microBusiness.isDeleted())
                                                            .managed(microBusiness.isManaged())
                                                            .category(microBusiness.getCategory())
                                                            .user(microBusiness.getUser())
                                                            .country(microBusiness.getCountry())
                                                            .province(microBusiness.getProvince())
                                                            .build();
        
        return microBusinessDTO;
    }
}
