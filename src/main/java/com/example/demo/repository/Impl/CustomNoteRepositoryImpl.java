package com.example.demo.repository.Impl;

import com.example.demo.models.Note;
import com.example.demo.models.QNote;
import com.example.demo.repository.CustomNoteRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomNoteRepositoryImpl  implements CustomNoteRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Note> findnoteetudiantbymatiere(int id){
        QNote qNote=QNote.note1;
        return new JPAQuery<Note>(em)
                .select(qNote)
                .from(qNote)
                .where(qNote.matiereId.eq(id))
                .fetch();
    }


}
