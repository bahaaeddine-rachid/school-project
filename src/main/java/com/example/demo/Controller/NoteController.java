package com.example.demo.Controller;

import com.example.demo.Service.NoteService;
import com.example.demo.models.Note;
import com.example.demo.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/note")
@Slf4j
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteService noteService;

    @RequestMapping(value="/findnoteetudiantbymatiereId", method = RequestMethod.GET)
    public ResponseEntity<List<Note>> findnoteetudiantbymatiere(@RequestParam int id){
        return ResponseEntity.ok(noteService.findnoteetudiantbymatiere(id));
    }

    @RequestMapping(value="/findnoteetudiantbyetudiantId", method = RequestMethod.GET)
    public ResponseEntity<List<Note>> findnoteetudiantbyetudiant(@RequestParam int id){
        return ResponseEntity.ok(noteService.findnoteetudiantbyetudiant(id));
    }
}
