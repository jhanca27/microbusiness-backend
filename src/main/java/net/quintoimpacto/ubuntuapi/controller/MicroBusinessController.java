package net.quintoimpacto.ubuntuapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.mapper.MicroBusinessMapper;
import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@RestController
@RequestMapping("/microbusiness")
public class MicroBusinessController {
    
    @Autowired
    private IMicroBusinessService microBusinessService;

    @PostMapping("/")
    public ResponseEntity<MicroBusinessDTO> save(@RequestBody MicroBusinessDTO microBusinessDTO) {
        MicroBusiness microBusiness = microBusinessService.save(microBusinessDTO);
        MicroBusinessDTO microBusinessDTOresponse = MicroBusinessMapper.toMicroBusinessDTO(microBusiness);
        return new ResponseEntity<>(microBusinessDTOresponse , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody MicroBusinessDTO microBusinessDTO, @PathVariable Long id){
        Optional<MicroBusiness> microBusinessOptional = microBusinessService.findById(id);

        if(microBusinessOptional.isPresent()){
            microBusinessService.update(microBusinessDTO);
            return ResponseEntity.ok("Registro actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
