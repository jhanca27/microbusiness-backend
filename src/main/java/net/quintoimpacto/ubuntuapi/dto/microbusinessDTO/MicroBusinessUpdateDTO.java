package net.quintoimpacto.ubuntuapi.dto.microbusinessDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.quintoimpacto.ubuntuapi.dto.ImageDTO;

import java.util.List;

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

    private String category;

    private String userFirst_name;

    private String provinceName;

    private String provinceCountryName;

    private List<ImageDTO> images; // Lista de imágenes relacionadas
}