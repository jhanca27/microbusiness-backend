package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.AnswerDTO;
import net.quintoimpacto.ubuntuapi.entity.Answer;
import net.quintoimpacto.ubuntuapi.repository.IAnswerRepository;
import net.quintoimpacto.ubuntuapi.service.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerImpl implements IAnswerService {

    @Autowired
    private IAnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDTO create(AnswerDTO answerDTO) {
        Answer autowired= modelMapper.map(answerDTO, Answer.class);
        Answer createAnswer= answerRepository.save(autowired);
        return modelMapper.map(createAnswer, AnswerDTO.class);
    }

    @Override
    public List<AnswerDTO> getAllAnswer() {
        List<Answer> answers= answerRepository.findAll();
        return answers.stream().map(answer -> modelMapper.map(answer, AnswerDTO.class))
                .collect(Collectors.toList());
    }
}
