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
public class MicroBusinessShowDto {

    private Long id;

    private String name;

    private String description;

    private String moreInformation;

    private Category category;

    private String subTitle;
}
