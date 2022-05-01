package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.ReportResponse;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/reports")
public class ReportController {
    private IngredientRepository ingredientRepository;

    @Autowired
    public ReportController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public List<ReportResponse> getReportIngredients(){
        return ingredientRepository.getReportIngredients();
    }

    @GetMapping("/ingredients/healthy")
    public List<ReportResponse> getReportHealthyIngredients(){
        return ingredientRepository.getReportHealthyIngredients();
    }
}
