package com.example.demo.Controller;

import com.example.demo.DTO.EtudiantDTO;
import com.example.demo.Service.EtudiantService;
import com.example.demo.Service.FiliereService;
import com.example.demo.models.Etudiant;
import com.example.demo.models.Note;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/etudiant")
@Slf4j
public class EtudiantController {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    FiliereService filiereService;

    @Autowired


    @GetMapping(value = "/findAllEtudiants")
    public ResponseEntity<List<Etudiant>> findAllEtudiants() {
        log.info("getting all etudiants");
        List<Etudiant> result = etudiantService.findAllEtudiants();
        log.info("all etudiants found");
        return ResponseEntity.ok(result);

    }



    @PostMapping(value = "/deleteEtudiant")
    public ResponseEntity<Boolean> deleteEtudiant(@RequestParam int id) {
        etudiantService.deleteEtudiant(id);
        log.info("deleted student");
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/findAllFilieresid", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> findAllFilieresid() {
        List<Integer> result = filiereService.findAllFilieresid();
        return ResponseEntity.ok(result);
    }


    @PostMapping(value = "/saveEtudiant")
    ResponseEntity<?> saveEtudiant(@RequestBody EtudiantDTO etudiant) {
        log.info(etudiant.toString());
        return ResponseEntity.ok(etudiantService.save(etudiant));
    }

    @RequestMapping(value="/findEtudiantbyFiliereId", method = RequestMethod.GET)
    public ResponseEntity<List<Etudiant>> findEtudiantbyFiliere(@RequestParam int id){
        return ResponseEntity.ok(etudiantService.findEtudiantbyFiliere(id));
    }


    @RequestMapping(value="/findEtudiantById", method = RequestMethod.GET)
    public ResponseEntity<List<Etudiant>> findEtudiantById(@RequestParam int id)  {
        List<Etudiant> result=etudiantService.findEtudiantByID(id);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/editEtudiant/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") int id, @RequestBody Etudiant etudiant) {
            Optional<Etudiant> EtudiantData = etudiantRepository.findById(id);

        if (EtudiantData.isPresent()) {
            Etudiant _etudiant = EtudiantData.get();
            _etudiant.setNom(etudiant.getNom());
            _etudiant.setPrenom(etudiant.getPrenom());
            _etudiant.setDatedenaissance(etudiant.getDatedenaissance());
            _etudiant.setSexe(etudiant.getSexe());
            return new ResponseEntity<>(etudiantRepository.save(_etudiant), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


