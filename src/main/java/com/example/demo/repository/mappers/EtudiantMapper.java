package com.example.demo.repository.mappers;


import com.example.demo.models.Etudiant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EtudiantMapper implements RowMapper<Etudiant> {
@Override
public Etudiant mapRow(ResultSet rs, int rowNum) throws SQLException {


        Etudiant etudiant= new Etudiant();

        etudiant.setId(rs.getInt("etudiant_id"));
        etudiant.setNom(rs.getString("nom"));
        etudiant.setPrenom(rs.getString("prenom"));
        etudiant.setDatedenaissance(rs.getString("datedenaissance"));
        etudiant.setSexe(rs.getString("sexe"));

        return etudiant;
}

}
