package com.example.formation.Controllers;

import com.example.formation.entites.Fonction;
import com.example.formation.entites.Formation;
import com.example.formation.services.FonctionService;
import com.example.formation.services.FormationService;
import com.example.formation.services.MapVAlidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Format;
import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {
    @Autowired
    FormationService formationService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Formation formation, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Formation formation1 = formationService.ajouter(formation);
        return new ResponseEntity<Formation>(formation1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormation(@PathVariable Long id) {
        return new ResponseEntity<Formation>(formationService.getFormationById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllFormation() {
        return new ResponseEntity<List<Formation>>(formationService.getAllFormation(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFormation(@PathVariable Long id) {
        formationService.delete(id);

    }

}
