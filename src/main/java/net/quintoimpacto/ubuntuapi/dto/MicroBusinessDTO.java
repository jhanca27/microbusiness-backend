package net.quintoimpacto.ubuntuapi.dto;

import lombok.Builder;
import lombok.Data;
import net.quintoimpacto.ubuntuapi.entity.Country;
import net.quintoimpacto.ubuntuapi.entity.Province;
import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

@Data
@Builder
public class MicroBusinessDTO {
  
    private Long id;

    private String name;

    private String description;

    private String moreInformation;

    private boolean deleted;

    private boolean managed;

    private Category category;

    private User user;

    private Country country;

    private Province province;
}
