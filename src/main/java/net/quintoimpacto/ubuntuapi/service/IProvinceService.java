package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;

import java.util.List;

public interface IProvinceService {
    public List<ProvinceDTO> getAllByCountry(Long id);
}
