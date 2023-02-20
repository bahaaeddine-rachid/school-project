package com.example.demo.repository.mappers;


import com.example.demo.models.Matiere;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatiereMapper implements RowMapper<Matiere> {

    @Override
    public Matiere mapRow(ResultSet rs, int rowNum) throws SQLException {

        Matiere matiere = new Matiere();

        matiere.setId(rs.getInt("id"));
        matiere.setNommatiere(rs.getString("nommatiere"));
        return matiere;

    }
    }

