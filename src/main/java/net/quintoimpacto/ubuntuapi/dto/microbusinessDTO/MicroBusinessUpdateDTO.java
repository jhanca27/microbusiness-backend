package net.quintoimpacto.ubuntuapi.dto.microbusinessDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.quintoimpacto.ubuntuapi.dto.ImageDTO;
import net.quintoimpacto.ubuntuapi.entity.Country;
import net.quintoimpacto.ubuntuapi.entity.Province;
import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroBusinessUpdateDTO {
    private Long id;

    private String name;

    private String description;

    private String moreInformation;

    private String subTitle;

    private Category category; // Campo para la descripción de la categoria

    private User user;

    private Province province;

    private Country provinceCountry;

    private List<ImageDTO> images; 
}
