package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.repository.IMicroBusinessRepository;
import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@Service
public class MicroBusinessImpl implements IMicroBusinessService{

    @Autowired
    private IMicroBusinessRepository microBusinessRepository;

    @Override
    public void save(MicroBusinessDTO microBusinessDTO) {
        ModelMapper mapper = new ModelMapper();
        var microBusiness = mapper.map(microBusinessDTO, MicroBusiness.class);
        microBusinessRepository.save(microBusiness);
    }

    @Override
    public void update(MicroBusinessDTO microBusinessDTO) {
        ModelMapper mapper = new ModelMapper();
        var microBusiness = mapper.map(microBusinessDTO, MicroBusiness.class);
        microBusinessRepository.save(microBusiness);
    }

    @Override
    public Optional<MicroBusiness> findById(Long id) {
        return microBusinessRepository.findById(id);
    }

    @Override
    public Set<MicroBusinessDTO> findByName(String name) {
        ModelMapper mapper = new ModelMapper();
        return microBusinessRepository.findByNameContainingIgnoreCase(name).stream()
                                                        .map(micro -> mapper.map(micro, MicroBusinessDTO.class))
                                                        .collect(Collectors.toSet());
    }

   
}
