package com.example.demo.DTO;

import com.example.demo.models.Filiere;
import lombok.Data;

import java.util.List;

@Data

public class FiliereDTO {

    Integer id;
    String nomfiliere;
    String abreviation;

    List<MatiereDTO> matiereDTOList;

    public FiliereDTO(Filiere filiere) {
        this.id = filiere.getId();
        this.nomfiliere = filiere.getNomfiliere();
        this.abreviation = filiere.getAbreviation();

    }
}
