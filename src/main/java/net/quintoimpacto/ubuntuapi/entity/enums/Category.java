package net.quintoimpacto.ubuntuapi.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    ECONOMIA_SOCIAL_DESARROLLO_LOCAL_INCLUSION_FINANCIERA("Economía Social/Desarrollo Local/Inclusión financiera"),
    AGROECOLOGIA_ORGANICOS_ALIMENTACION_SALUDABLE("Agroecología/Organicos/Alimentación saludable"),
    CONSERVACION_REGENERACION_SERVICIOS_ECOSISTEMICOS("Conservación/Regeneración/Servicios Ecosistémicos"),
    EMPRESAS_ORGANISMOS_DE_IMPACTO_ECONOMIA_CIRCULAR("Empresas/Organismos de impacto/Economia circular");

    private final String description;

}
