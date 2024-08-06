package net.quintoimpacto.ubuntuapi.service.serviceImpl;

import net.quintoimpacto.ubuntuapi.dto.QuestionDTO;
import net.quintoimpacto.ubuntuapi.entity.Question;
import net.quintoimpacto.ubuntuapi.entity.enums.Hierarchy;
import net.quintoimpacto.ubuntuapi.exception.ValidateIntegrity;
import net.quintoimpacto.ubuntuapi.mapper.QuestionMapper;
import net.quintoimpacto.ubuntuapi.repository.IQuestionRepository;
import net.quintoimpacto.ubuntuapi.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public QuestionDTO create(QuestionDTO questionDTO) {
        Question question= questionMapper.questionDTO2Entity(questionDTO);
        Question createQuestion= questionRepository.save(question);
        return questionMapper.question2DTO(createQuestion);
    }

    @Override
    public List<QuestionDTO> getAllQuestion() {
        List<Question> questions= questionRepository.findByActive(true);
        return questions.stream().map(questionMapper::question2DTO).collect(Collectors.toList());
    }

    @Override
    public List<QuestionDTO> getInitialQuestion() {
        List<Question> questions= questionRepository.findByInitial(true);
        return questions.stream().map(questionMapper::question2DTO).collect(Collectors.toList());
    }

    @Override
    public QuestionDTO update(QuestionDTO questionDTO, Long id) {
        //busca la pregunta existente
        Question question= questionRepository.findById(id).orElseThrow(() -> new ValidateIntegrity("Question not found with id " + id));
        //Actualiza los campos de la pregunta
        question.setQuestionText(questionDTO.getQuestionText());
        question.setHierarchy(Hierarchy.fromDescription(questionDTO.getHierarchyDescription()));
        question.setActive(questionDTO.isActive());
        question.setInitial(questionDTO.isInitial());
        Question updateQuestion= questionRepository.save(question);//guarda la pregunta actualizada
        return questionMapper.question2DTO(updateQuestion);//convertir la entidad actualizada a DTO y devuelve
    }
}
