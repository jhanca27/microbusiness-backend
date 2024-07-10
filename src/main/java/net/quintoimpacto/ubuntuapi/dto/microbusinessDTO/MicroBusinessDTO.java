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

    private boolean deleted;

    private boolean managed;

    private Category category;

    private String userFirst_name;

    /* private Country country; */

    private String provinceName;

    private String provinceCountryName;
}
