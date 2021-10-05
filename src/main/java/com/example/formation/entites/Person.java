package com.example.formation.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull(message = "champ obligatoire")
    private String nom;

    //@OneToMany(mappedBy = "person",fetch = FetchType.LAZY,cascade = )
    //List<Validation> validations;

    @ManyToMany
    private List<Formation> formations;
    @ManyToOne
    private Fonction fonctions;

}
