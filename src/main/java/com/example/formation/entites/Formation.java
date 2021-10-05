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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull(message = "champ obligatoire")
    private String label;

    @ManyToOne
    private Categorie categorie;

    //@ManyToMany
    //private List<Fonction> fonctions;

}
