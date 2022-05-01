package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.IngredientResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientRepository;
import com.lukafilipovic.PancakesUnlimitedApp.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService, IngredientRepository ingredientRepository) {
        this.ingredientService = ingredientService;
    }

    @PostMapping()
    public ResponseEntity<IngredientResponseDto> addIngredient(@Valid @RequestBody IngredientDto ingredientDto){
        return new ResponseEntity<>(ingredientService.addIngredient(ingredientDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable(name="id") long id){
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>("Ingredient deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientResponseDto> updateIngredient(@Valid @RequestBody IngredientDto ingredientDto, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(ingredientService.updateIngredient(ingredientDto, id), HttpStatus.OK);
    }

    @GetMapping
    public List<IngredientResponseDto> viewAllIngredients(){
        return ingredientService.viewAllIngredients();
    }

}
