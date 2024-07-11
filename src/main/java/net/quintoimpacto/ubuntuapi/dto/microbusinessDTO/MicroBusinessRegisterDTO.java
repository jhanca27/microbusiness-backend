package net.quintoimpacto.ubuntuapi.dto.microbusinessDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.quintoimpacto.ubuntuapi.entity.Province;
import net.quintoimpacto.ubuntuapi.entity.User;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroBusinessRegisterDTO {

    private String name;

    private String description;

    private String moreInformation;

    private String subTitle;

    private Category category;

    private Province province;

    private User user;
}
