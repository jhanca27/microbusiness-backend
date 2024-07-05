package net.quintoimpacto.ubuntuapi.service;

import java.util.Optional;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;

public interface IMicroBusinessService {
    
    public MicroBusiness save(MicroBusinessDTO microBusinessDTO);
    
    public void update(MicroBusinessDTO microBusinessDTO);

    public Optional<MicroBusiness> findById(Long id);
}
