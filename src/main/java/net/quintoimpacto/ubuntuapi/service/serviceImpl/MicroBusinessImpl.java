package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.mapper.MicroBusinessMapper;
import net.quintoimpacto.ubuntuapi.repository.IMicroBusinessRepository;
import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@Service
public class MicroBusinessImpl implements IMicroBusinessService{

    @Autowired
    private IMicroBusinessRepository microBusinessRepository;

    @Override
    public MicroBusiness save(MicroBusinessDTO microBusinessDTO) {
        MicroBusiness microBusiness = MicroBusinessMapper.toMicroBusinessEntity(microBusinessDTO);
        return microBusinessRepository.save(microBusiness);

    }

    @Override
    public void update(MicroBusinessDTO microBusinessDTO) {
        MicroBusiness microBusiness = MicroBusinessMapper.toMicroBusinessEntity(microBusinessDTO);
        microBusinessRepository.save(microBusiness);
    }

    @Override
    public Optional<MicroBusiness> findById(Long id) {
        return microBusinessRepository.findById(id);
    }

   
}
