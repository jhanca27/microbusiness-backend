package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import net.quintoimpacto.ubuntuapi.dto.CategoryDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessRegisterDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessShowDto;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.repository.IMicroBusinessRepository;
import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@Service
public class MicroBusinessImpl implements IMicroBusinessService{

    @Autowired
    private IMicroBusinessRepository microBusinessRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MicroBusinessShowDto save(MicroBusinessRegisterDTO microBusinessDTO) {
        var microBusiness = modelMapper.map(microBusinessDTO, MicroBusiness.class);
        microBusiness = microBusinessRepository.save(microBusiness);
        System.out.println(microBusiness);
        return modelMapper.map(microBusiness,MicroBusinessShowDto.class);
    }

    @Override
    public void update(MicroBusinessDTO microBusinessDTO) {
        var microBusiness = modelMapper.map(microBusinessDTO, MicroBusiness.class);
        microBusinessRepository.save(microBusiness);
    }

    @Override
    public Optional<MicroBusiness> findById(Long id) {
        return microBusinessRepository.findById(id);
    }

    @Override
    public Set<MicroBusinessDTO> findByName(String name) {
        return microBusinessRepository.findByNameContainingIgnoreCase(name).stream()
                                                        .map(micro -> modelMapper.map(micro, MicroBusinessDTO.class))
                                                        .collect(Collectors.toSet());
    }

    @Override
    public List<MicroBusinessDTO> findByCategory(Category category) {
        List<MicroBusiness> microBusinesses= microBusinessRepository.findByCategory(category);
        return microBusinesses.stream()
                .map(microBusiness -> modelMapper
                        .map(microBusiness, MicroBusinessDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return Arrays.stream(Category.values())
                .map(category -> modelMapper
                        .map(category, CategoryDTO.class)).collect(Collectors.toList());
    }
}
