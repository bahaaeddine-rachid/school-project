package com.example.demo.repository.mappers;

import com.example.demo.models.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteMapper implements RowMapper<Note> {


    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {

        Note note = new Note();


        return note;

    }
    }
