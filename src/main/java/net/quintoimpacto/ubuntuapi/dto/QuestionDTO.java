package net.quintoimpacto.ubuntuapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.quintoimpacto.ubuntuapi.entity.Answer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    @NotNull(message = "The question cannot be null.")
    private String questionText;
    private String hierarchyDescription;
    private boolean active;
    private boolean initial;
    private List<Answer> answers;
    private Answer answer;
}
