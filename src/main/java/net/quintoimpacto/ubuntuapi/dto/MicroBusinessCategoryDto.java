package net.quintoimpacto.ubuntuapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MicroBusinessCategoryDto {

    private Long id;

    private String name;

    private String description;

    private String moreInformation;

    private Category category;
}
