package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.QuestionDTO;

import java.util.List;

public interface IQuestionService {

    QuestionDTO create(QuestionDTO questionDTO);
    List<QuestionDTO> getAllQuestion();
    List<QuestionDTO> getInitialQuestion();
    QuestionDTO update(QuestionDTO questionDTO, Long id);
}
