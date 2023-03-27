package com.example.demo.Controller;

import com.example.demo.Service.FiliereMatiereService;
import com.example.demo.Service.NiveauService;
import com.example.demo.models.Etudiant;
import com.example.demo.models.FiliereMatiere;
import com.example.demo.models.Niveau;
import com.example.demo.repository.NiveauRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filierematiere")
@Slf4j
public class FiliereMatiereController {
    @Autowired
    NiveauRepository niveauRepository;

    @Autowired
    NiveauService niveauService;
    @Autowired
    FiliereMatiereService filiereMatiereService;
    @RequestMapping(value="/findmatierebyfiliere", method = RequestMethod.GET)
    public ResponseEntity<List<FiliereMatiere>> findmatierebyfiliere(@RequestParam int id,int niveau){
        return ResponseEntity.ok(filiereMatiereService.findmatierebyfiliere(id,niveau));
    }

    @GetMapping(value = "/findAllFiliereMatiere")
    public ResponseEntity<List<FiliereMatiere>> findAllFiliereMatiere() {

        List<FiliereMatiere> result = filiereMatiereService.findAllFiliereMatiere();
        return ResponseEntity.ok(result);

    }




}
