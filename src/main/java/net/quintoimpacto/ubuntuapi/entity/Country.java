package net.quintoimpacto.ubuntuapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Country name cannot be null")
    private String name;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Province> province;
}
