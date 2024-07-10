package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.ProvinceDTO;
import net.quintoimpacto.ubuntuapi.entity.Province;
import net.quintoimpacto.ubuntuapi.mapper.ProvinceMapper;
import net.quintoimpacto.ubuntuapi.repository.IProvinceRepository;
import net.quintoimpacto.ubuntuapi.service.IProvinceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Set<ProvinceDTO> findByName(String name) {
        ModelMapper mapper = new ModelMapper();
        return provinceRepository.findByNameContainingIgnoreCase(name).stream()
                .map(p -> mapper.map(p, ProvinceDTO.class))
                .collect(Collectors.toSet());
    }
}
