package net.quintoimpacto.ubuntuapi.service;


import net.quintoimpacto.ubuntuapi.dto.CountryDTO;

import java.util.List;

public interface ICountryService {
    public List<CountryDTO> getAllCountries();
}
