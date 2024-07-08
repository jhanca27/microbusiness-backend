package net.quintoimpacto.ubuntuapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessCategoryDto;
import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;

public interface IMicroBusinessService {
    
    public void save(MicroBusinessDTO microBusinessDTO);
    
    public void update(MicroBusinessDTO microBusinessDTO);

    public Optional<MicroBusiness> findById(Long id);

    public Set<MicroBusinessDTO> findByName(String name);
    public List<MicroBusinessCategoryDto> findByCategory(Category category);
}
