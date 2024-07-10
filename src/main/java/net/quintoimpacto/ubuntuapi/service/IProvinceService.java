package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;

import java.util.Set;

public interface IProvinceService {
    public Set<ProvinceDTO> findByName(String name);
}
