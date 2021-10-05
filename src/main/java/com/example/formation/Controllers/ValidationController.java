package com.example.formation.Controllers;

import com.example.formation.entites.Formation;
import com.example.formation.entites.Validation;
import com.example.formation.services.FormationService;
import com.example.formation.services.MapVAlidationErrorService;
import com.example.formation.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {
    @Autowired
    ValidationService validationService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Validation validation, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Validation validation1 = validationService.ajouter(validation);
        return new ResponseEntity<Validation>(validation1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getValidation(@PathVariable Long id) {
        return new ResponseEntity<Validation>(validationService.getvalidationById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllValidation() {
        return new ResponseEntity<List<Validation>>(validationService.getAllvalidation(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletevalidation(@PathVariable Long id) {
        validationService.delete(id);

    }

}
