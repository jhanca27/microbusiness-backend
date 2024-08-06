package net.quintoimpacto.ubuntuapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.quintoimpacto.ubuntuapi.entity.Question;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    @NotNull(message = "The answer cannot be null.")
    private String answerText;
    private Question question;
    private List<Question> subQuestion;
}
