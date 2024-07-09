package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.dto.CountryDTO;
import net.quintoimpacto.ubuntuapi.service.ICountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping()
    public ResponseEntity<List<CountryDTO>> getAll () {
        List<CountryDTO> countriesDTO = countryService.getAllCountries();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countriesDTO);
    }
}
