package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/{categoryId}")
    public ResponseEntity<IngredientDto> addIngredient(@RequestBody IngredientDto ingredientDto, @PathVariable(name = "categoryId") long categoryId){
        return new ResponseEntity<>(ingredientService.addIngredient(ingredientDto,categoryId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable(name="id") long id){
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>("Ingredient deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDto> updateIngredient(@RequestBody IngredientDto ingredientDto, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(ingredientService.updateIngredient(ingredientDto, id), HttpStatus.OK);
    }

    @GetMapping
    public List<IngredientDto> viewAllIngredients(){
        return ingredientService.viewAllIngredients();
    }
}
