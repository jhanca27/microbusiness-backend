package net.quintoimpacto.ubuntuapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import net.quintoimpacto.ubuntuapi.dto.CategoryDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessRegisterDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessShowDto;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessUpdateDTO;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

public interface IMicroBusinessService {
    
    public MicroBusinessShowDto save(MicroBusinessRegisterDTO microBusinessDTO);
    public void update(MicroBusinessDTO microBusinessDTO, Long id);
    public Optional<MicroBusiness> findById(Long id);
    public Set<MicroBusinessDTO> findByName(String name);
    public List<MicroBusinessDTO> findByCategory(Category category);
    public List<CategoryDTO> getAllCategory();
    public Set<MicroBusinessDTO> findByUserEmailMicroBusiness(String email);
    public Optional<MicroBusiness> findByIdAndUserEmail(Long id, String email);
    public void delete(Long id, String email);
    public List<MicroBusinessDTO> findAll();
}