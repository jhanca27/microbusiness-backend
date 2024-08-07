package net.quintoimpacto.ubuntuapi.entity;



import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_requests")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class ContactRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nombre no puede estar vacio")
    private String fullName;

    @Email
    private String email;

    
    private String phoneNumber;

    @NotNull(message = "Mensaje no puede estar vacío")
    private String message;

    @Column(columnDefinition = "boolean default false")
    private boolean stateRequest;

    @ManyToOne
    @JoinColumn(name = "micro_id", nullable = true )
    private MicroBusiness microBusiness;


}
