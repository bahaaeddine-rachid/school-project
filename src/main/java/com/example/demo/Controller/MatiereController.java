package com.example.demo.Controller;

import com.example.demo.Service.EtudiantService;
import com.example.demo.Service.MatiereService;
import com.example.demo.models.Etudiant;
import com.example.demo.models.Matiere;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.MatiereRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/matiere")
@Slf4j
public class MatiereController {
    @Autowired
    MatiereService matiereService;
    @Autowired
    private MatiereRepository matiereRepository;

    @GetMapping(value = "/findAllMatieres")
    public ResponseEntity<List<Matiere>> findAllMatieres() {
        log.info("getting all matiers");
        List<Matiere> result = matiereService.findAllMatieres();
        log.info("all matieres found");
        return ResponseEntity.ok(result);

    }
}
