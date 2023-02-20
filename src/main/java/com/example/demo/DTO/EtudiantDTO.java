package com.example.demo.DTO;

import lombok.Data;

@Data
public class EtudiantDTO {

    Integer id;
    String nom;
    String prenom;
    String dateNaissance;
    String sexe;
    Integer filiereId;
    String nomfiliere;


}
