package com.example.formation.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Validation {

    @Id
    private Long id;
    private Date dateValidation;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Formation formation;


}
