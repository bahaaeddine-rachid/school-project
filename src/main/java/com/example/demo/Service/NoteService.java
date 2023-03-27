package com.example.demo.Service;

import com.example.demo.models.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> findnoteetudiantbymatiere(int id){

        return noteRepository.findnoteetudiantbymatiere(id);
    }

    public List<Note> findnoteetudiantbyetudiant(int id){

        return noteRepository.findnoteetudiantbyetudiant(id);
    }
}

