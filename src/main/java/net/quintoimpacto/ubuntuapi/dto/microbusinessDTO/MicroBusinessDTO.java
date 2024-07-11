package net.quintoimpacto.ubuntuapi.dto.microbusinessDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroBusinessDTO {
  
    private Long id;

    private String name;

    private String description;

    private String moreInformation;

    private String subTitle;

    //private String categoryName; // Campo para el nombre de la categoría

    //private Category category;
    private String categoryDescription; // Campo para la descripción de la categoria

    private String userFirst_name;

    /* private Country country; */

    private String provinceName;

    private String provinceCountryName;
}
