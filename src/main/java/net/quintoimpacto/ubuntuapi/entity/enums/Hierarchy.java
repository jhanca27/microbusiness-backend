package net.quintoimpacto.ubuntuapi.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Hierarchy {

    CONTACT("¿Cómo puedo contactar a los emprendedores?"),
    ADD_MICROBUSINESS("¿Cómo sumar mi emprendimiento a Ubuntu?"),
    COSTS("¿Cúales son los costos de participar en Ubuntu?");

    private String description;
}
