package net.quintoimpacto.ubuntuapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import net.quintoimpacto.ubuntuapi.dto.CategoryDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessRegisterDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessShowDto;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

public interface IMicroBusinessService {
    MicroBusinessShowDto save(MicroBusinessRegisterDTO microBusinessDTO);
    void update(MicroBusinessDTO microBusinessDTO);
    Optional<MicroBusinessDTO> findById(Long id);
    Set<MicroBusinessDTO> findByName(String name);
    List<MicroBusinessDTO> findByCategory(Category category);
    List<CategoryDTO> getAllCategory();
}