package com.example.demo.repository.mappers;

import com.example.demo.models.Filiere;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FiliereMapper implements RowMapper<Filiere> {

        @Override
        public Filiere mapRow(ResultSet rs, int rowNum) throws SQLException {


            Filiere filiere= new Filiere();
            filiere.setId(rs.getInt("filiere_id"));
            filiere.setNomfiliere(rs.getString("nomfiliere"));
            filiere.setAbreviation(rs.getString("abreviation"));
            return filiere;
        }
}
