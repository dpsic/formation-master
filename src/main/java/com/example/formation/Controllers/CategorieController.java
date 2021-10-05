package com.example.formation.Controllers;

import com.example.formation.entites.Categorie;
import com.example.formation.services.CategorieService;
import com.example.formation.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
   CategorieService categorieService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Categorie categorie, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Categorie categorie1 = categorieService.ajouter(categorie);
        return new ResponseEntity<Categorie>(categorie1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategorie(@PathVariable Long id) {
        return new ResponseEntity<Categorie>(categorieService.getCategorieById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategorie() {
        return new ResponseEntity<List<Categorie>>(categorieService.getAllCategorie(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
       categorieService.delete(id);

    }

}
