package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;

import java.util.List;
import java.util.Set;

public interface IProvinceService {
    Set<ProvinceDTO> findByName(String name);
    List<ProvinceDTO> findByCountryId(Long countryId);
}