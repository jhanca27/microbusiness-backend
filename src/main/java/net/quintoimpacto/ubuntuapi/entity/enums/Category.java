package net.quintoimpacto.ubuntuapi.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    SOCIAL_ECONOMY("Economía Social"),
    AGROECOLOGY("Agroecología"),
    CONSERVATION("Conservación"),
    COMPANIES_IMPACT("Empresas de Impacto");

    private final String description;

}
