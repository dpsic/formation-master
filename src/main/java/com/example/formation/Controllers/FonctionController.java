package com.example.formation.Controllers;


import com.example.formation.entites.Fonction;
import com.example.formation.services.FonctionService;
import com.example.formation.services.MapVAlidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fonctions")
public class FonctionController {
    @Autowired
    FonctionService fonctionService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Fonction fonction, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
       Fonction fonction1 = fonctionService.ajouter(fonction);
        return new ResponseEntity<Fonction>(fonction1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFonction(@PathVariable Long id) {
        return new ResponseEntity<Fonction>(fonctionService.getfonctionById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllFonction() {
        return new ResponseEntity<List<Fonction>>(fonctionService.getAllfonction(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFonction(@PathVariable Long id) {
        fonctionService.delete(id);

    }

}
