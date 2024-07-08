package net.quintoimpacto.ubuntuapi.service;

import java.util.Optional;
import java.util.Set;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;

public interface IMicroBusinessService {
    
    public void save(MicroBusinessDTO microBusinessDTO);
    
    public void update(MicroBusinessDTO microBusinessDTO);

    public Optional<MicroBusiness> findById(Long id);

    public Set<MicroBusinessDTO> findByName(String name);
}
