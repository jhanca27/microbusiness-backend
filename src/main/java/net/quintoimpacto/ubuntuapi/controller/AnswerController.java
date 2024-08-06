package net.quintoimpacto.ubuntuapi.controller;

import jakarta.validation.Valid;
import net.quintoimpacto.ubuntuapi.dto.AnswerDTO;
import net.quintoimpacto.ubuntuapi.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    @PostMapping("/create")
    public ResponseEntity<AnswerDTO> createAnswer(@Valid @RequestBody AnswerDTO answerDTO){
        if (answerDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }try {
            return ResponseEntity.status(HttpStatus.CREATED).body(answerService.create(answerDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnswerDTO>> getAllAnswers(){
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAllAnswer());
    }
}
