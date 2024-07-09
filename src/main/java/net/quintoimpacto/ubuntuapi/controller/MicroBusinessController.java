package net.quintoimpacto.ubuntuapi.controller;

import java.util.List;
import java.util.Optional;

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessCategoryDto;
import net.quintoimpacto.ubuntuapi.entity.enums.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import net.quintoimpacto.ubuntuapi.dto.MicroBusinessDTO;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;
import net.quintoimpacto.ubuntuapi.service.IMicroBusinessService;

@RestController
@RequestMapping("/microbusiness")
public class MicroBusinessController {
    
    @Autowired
    private IMicroBusinessService microBusinessService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody MicroBusinessDTO microBusinessDTO) {
        microBusinessService.save(microBusinessDTO);
        return new ResponseEntity<>("Microbusiness creado" , HttpStatus.CREATED);
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

    @GetMapping("/")
    public ResponseEntity<?> searhByName(@RequestParam("search") String name) {
        var setMicroBusinessDTO = microBusinessService.findByName(name);
        return new ResponseEntity<>(setMicroBusinessDTO, HttpStatus.valueOf(200));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MicroBusinessCategoryDto>> searchCategory(@PathVariable Category category){
        return ResponseEntity.status(HttpStatus.OK).body(microBusinessService.findByCategory(category));
    }

    @GetMapping("/categories")
    private ResponseEntity<List<MicroBusinessCategoryDto>> searchAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(microBusinessService.getAllCategory());
    }
}
