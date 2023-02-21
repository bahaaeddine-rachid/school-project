package com.example.demo.Controller;

import com.example.demo.Service.NiveauService;
import com.example.demo.models.Niveau;
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
@RequestMapping("/niveau")
@Slf4j
public class NiveauController {


    @Autowired
    NiveauService niveauService;
    @GetMapping(value = "/findAllNiveau")
    public ResponseEntity<List<Niveau>> findAllNiveau() {
        List<Niveau> result = niveauService.findAllNiveau();
        return ResponseEntity.ok(result);

    }
}
