package com.example.demo.Controller;

import com.example.demo.Service.FiliereMatiereService;
import com.example.demo.models.Etudiant;
import com.example.demo.models.FiliereMatiere;
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
    FiliereMatiereService filiereMatiereService;
    @RequestMapping(value="/findmatierebyfiliere", method = RequestMethod.GET)
    public ResponseEntity<List<FiliereMatiere>> findmatierebyfiliere(@RequestParam int id){
        return ResponseEntity.ok(filiereMatiereService.findmatierebyfiliere(id));
    }

    @GetMapping(value = "/findAllNiveau")
    public ResponseEntity<List<?>> findAllniveau() {
        List<?> result = filiereMatiereService.findAllniveau();
        return ResponseEntity.ok(result);

    }

}
