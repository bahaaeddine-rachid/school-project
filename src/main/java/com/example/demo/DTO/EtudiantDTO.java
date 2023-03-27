package com.example.demo.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EtudiantDTO {

    Integer id;
    String nom;
    String prenom;
    String datedenaissance;
    String sexe;
    Integer filiereId;
    String nomfiliere;


}
