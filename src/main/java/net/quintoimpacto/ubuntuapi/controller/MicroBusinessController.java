package net.quintoimpacto.ubuntuapi.controller;

import java.util.List;
import java.util.Optional;

import net.quintoimpacto.ubuntuapi.dto.CategoryDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessRegisterDTO;
import net.quintoimpacto.ubuntuapi.dto.microbusinessDTO.MicroBusinessShowDto;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@RestController
@RequestMapping("/microbusiness")
public class MicroBusinessController {

    @Autowired
    private IMicroBusinessService microBusinessService;

    @PostMapping("/")
    public ResponseEntity<MicroBusinessShowDto> save(@RequestBody MicroBusinessRegisterDTO microBusinessDTO) {
        System.out.println(microBusinessDTO);
        var microBusiness = microBusinessService.save(microBusinessDTO);
        return new ResponseEntity<>( microBusiness , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody MicroBusinessDTO microBusinessDTO, @PathVariable Long id){
        Optional<MicroBusinessDTO> microBusinessOptional = microBusinessService.findById(id);

        if(microBusinessOptional.isPresent()){
            microBusinessService.update(microBusinessDTO);
            return ResponseEntity.ok("Registro actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> searhByName(@RequestParam("search") String name) {
        var setMicroBusinessDTO = microBusinessService.findByName(name);
        return new ResponseEntity<>(setMicroBusinessDTO, HttpStatus.valueOf(200));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MicroBusinessDTO>> searchCategory(@PathVariable Category category){
        return ResponseEntity.status(HttpStatus.OK).body(microBusinessService.findByCategory(category));
    }

    @GetMapping("/categories")
    private ResponseEntity<List<CategoryDTO>> searchAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(microBusinessService.getAllCategory());
    }
}