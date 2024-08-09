package net.quintoimpacto.ubuntuapi.dto.ContactRequestDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.quintoimpacto.ubuntuapi.entity.MicroBusiness;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDTO {
    
    @NotNull(message = "Nombre no puede estar vacío")
    private String fullName;

    @Email
    private String email;

    private String phoneNumber;

    @NotNull(message = "Mensaje no puede estar vacío")
    private String message;

    private boolean stateRequest;

    private MicroBusiness microBusiness;
}
