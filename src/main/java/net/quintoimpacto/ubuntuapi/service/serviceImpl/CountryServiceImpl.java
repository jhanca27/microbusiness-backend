package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.CountryDTO;
import net.quintoimpacto.ubuntuapi.entity.Country;
import net.quintoimpacto.ubuntuapi.mapper.CountryMapper;
import net.quintoimpacto.ubuntuapi.repository.ICountryRepository;
import net.quintoimpacto.ubuntuapi.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(CountryMapper::toCountryDTO).collect(Collectors.toList());
    }
}
