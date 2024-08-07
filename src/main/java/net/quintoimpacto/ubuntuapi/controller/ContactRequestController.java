package net.quintoimpacto.ubuntuapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.quintoimpacto.ubuntuapi.dto.ContactRequestDTO.ContactRequestDTO;
import net.quintoimpacto.ubuntuapi.dto.ContactRequestDTO.ContactRequestShowDTO;
import net.quintoimpacto.ubuntuapi.service.IContactRequestService;

@RestController
@RequestMapping("/contact")
public class ContactRequestController {
    

    @Autowired
    private IContactRequestService contactRequestService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody @Valid ContactRequestDTO contactDTO){
        contactRequestService.save(contactDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ContactRequestDTO contactDTO,@PathVariable Long id){
        Optional<ContactRequestShowDTO> contactFind = contactRequestService.findById(id);

        if(contactFind.isPresent()){
            contactRequestService.update(contactDTO, id);
            return  ResponseEntity.ok("Registro actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Long id){
        Optional<ContactRequestShowDTO> contactFind = contactRequestService.findById(id);

        if(contactFind.isPresent()){
            return  new ResponseEntity<>(contactFind.get(), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<ContactRequestShowDTO> contactFind = contactRequestService.findById(id);
        if(contactFind.isPresent()){
            contactRequestService.delete(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/search/microbusiness/{id}")
    public ResponseEntity<List<ContactRequestShowDTO>> searchByMicrobusiness(@PathVariable Long id){
        var listContactRequests = contactRequestService.findByMicrobusinessId(id);
        return  new ResponseEntity<>(listContactRequests, HttpStatus.OK);
    }

    @GetMapping("/search/manage")
    public ResponseEntity<List<ContactRequestShowDTO>> searchManage(){
        var listContactRequests = contactRequestService.findByManage();
        return  new ResponseEntity<>(listContactRequests, HttpStatus.OK);
    }

    @GetMapping("/search/nomanage")
    public ResponseEntity<List<ContactRequestShowDTO>> searchNOManage(){
        var listContactRequests = contactRequestService.findByNoManage();
        return  new ResponseEntity<>(listContactRequests, HttpStatus.OK);
    }

}
