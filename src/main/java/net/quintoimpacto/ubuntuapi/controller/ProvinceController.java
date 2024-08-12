package net.quintoimpacto.ubuntuapi.controller;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;
import net.quintoimpacto.ubuntuapi.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/")
    public ResponseEntity<?> searhByName(@RequestParam("search") String name) {
        var setProvinceDTO = provinceService.findByName(name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(setProvinceDTO);
    }

    @GetMapping("/byCountry")
    public ResponseEntity<List<ProvinceDTO>> getByCountryId(@RequestParam("countryId") Long countryId) {
        List<ProvinceDTO> provinces = provinceService.findByCountryId(countryId);
        return ResponseEntity.status(HttpStatus.OK).body(provinces);
    }
}