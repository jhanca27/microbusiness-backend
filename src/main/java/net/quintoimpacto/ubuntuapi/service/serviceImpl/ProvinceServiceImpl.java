package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;
import net.quintoimpacto.ubuntuapi.entity.Province;
import net.quintoimpacto.ubuntuapi.mapper.ProvinceMapper;
import net.quintoimpacto.ubuntuapi.repository.IProvinceRepository;
import net.quintoimpacto.ubuntuapi.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public List<ProvinceDTO> getAllByCountry(Long id) {
        List<Province> provinces = provinceRepository.findAll();
        return provinces.stream().map(ProvinceMapper::toProvinceDTO).collect(Collectors.toList());
    }
}
