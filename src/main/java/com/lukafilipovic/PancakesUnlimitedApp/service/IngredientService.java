package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.IngredientResponseDto;

import java.util.List;

public interface IngredientService {
    IngredientResponseDto addIngredient(IngredientDto ingredientDto);
    void deleteIngredient(long id);
    IngredientResponseDto updateIngredient(IngredientDto ingredientDto, long id);
    List<IngredientResponseDto> viewAllIngredients();
}
