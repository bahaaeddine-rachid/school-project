package com.example.demo.Controller;

import com.example.demo.DTO.FiliereDTO;
import com.example.demo.Service.FiliereService;
import com.example.demo.models.Etudiant;
import com.example.demo.models.Filiere;
import com.example.demo.models.FiliereMatiere;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filiere")
@Slf4j
public class FiliereController {
    @Autowired
    FiliereService filiereService;

    @GetMapping(value = "/findAllFilieres")
    public ResponseEntity<List<FiliereDTO>> findAllFilieres(){
        log.info("getting all Filieres");
        List<FiliereDTO> result= filiereService.findAllFilieres();
        log.info("all Filieres found");
        return ResponseEntity.ok(result);

    }


}
