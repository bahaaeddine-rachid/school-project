package com.example.demo.repository;

import com.example.demo.models.Note;

import java.util.List;

public interface CustomNoteRepository {

    List<Note> findnoteetudiantbymatiere(int id);
    List<Note> findnoteetudiantbyetudiant(int id);

}
