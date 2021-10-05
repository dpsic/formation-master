package com.example.formation.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @NotNull(message = "champ obligatoire")
    private String label;
    @NotNull(message = "champ obligatoire")
    private String profil;

    @ManyToMany
    private List<Formation> formations;
    //@ManyToMany
   // private List<Person> persons;
}
