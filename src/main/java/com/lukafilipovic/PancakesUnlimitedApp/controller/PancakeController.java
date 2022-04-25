package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeDto;
import com.lukafilipovic.PancakesUnlimitedApp.service.PancakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pancakes")
public class PancakeController {
    private PancakeService pancakeService;

    public PancakeController(PancakeService pancakeService) {
        this.pancakeService = pancakeService;
    }

    @PostMapping("/{ingredientIds}")
    private ResponseEntity<PancakeDto> createPancake(@PathVariable(name = "ingredientIds") List<Long> ingredientIds){
        return new ResponseEntity<>(pancakeService.createPancake(ingredientIds), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deletePancake(@PathVariable(name="id") long id){
        pancakeService.deletePancake(id);
        return new ResponseEntity<>("Pancake deleted.", HttpStatus.OK);
    }
    @PutMapping("/{id}/ingredients/{ingredientIds}")
    private ResponseEntity<PancakeDto> updatePancake(@PathVariable(name="id") long id, @PathVariable(name="ingredientIds") List<Long> ingredientIds){
        return new ResponseEntity<>(pancakeService.updatePancake(id, ingredientIds), HttpStatus.OK);
    }

    @GetMapping
    private List<PancakeDto> getAllPancakes(){
        return pancakeService.getAllPancakes();
    }

    @GetMapping("/{id}")
    private ResponseEntity<PancakeDto> getPancakeById(@PathVariable(name="id") long id){
        return new ResponseEntity<>(pancakeService.getPancakeById(id), HttpStatus.OK);
    }
}
