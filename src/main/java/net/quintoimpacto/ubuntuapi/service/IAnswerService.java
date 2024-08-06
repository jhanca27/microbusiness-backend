package net.quintoimpacto.ubuntuapi.service;

import net.quintoimpacto.ubuntuapi.dto.AnswerDTO;

import java.util.List;

public interface IAnswerService {

    AnswerDTO create(AnswerDTO answerDTO);
    List<AnswerDTO> getAllAnswer();
}
