package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.PancakeDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.PancakeResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.service.PancakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pancakes")
public class PancakeController {
    private PancakeService pancakeService;

    public PancakeController(PancakeService pancakeService) {
        this.pancakeService = pancakeService;
    }

    @PostMapping()
    private ResponseEntity<PancakeResponseDto> createPancake(@Valid @RequestBody PancakeDto pancakeDto){
        return new ResponseEntity<>(pancakeService.createPancake(pancakeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deletePancake(@PathVariable(name="id") long id){
        pancakeService.deletePancake(id);
        return new ResponseEntity<>("Pancake deleted.", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    private ResponseEntity<PancakeResponseDto> updatePancake(@Valid @PathVariable(name="id") long id, @RequestBody PancakeDto pancakeDto){
        return new ResponseEntity<>(pancakeService.updatePancake(id, pancakeDto), HttpStatus.OK);
    }

    @GetMapping
    private List<PancakeResponseDto> getAllPancakes(){
        return pancakeService.getAllPancakes();
    }

    @GetMapping("/{id}")
    private ResponseEntity<PancakeResponseDto> getPancakeById(@PathVariable(name="id") long id){
        return new ResponseEntity<>(pancakeService.getPancakeById(id), HttpStatus.OK);
    }
}
