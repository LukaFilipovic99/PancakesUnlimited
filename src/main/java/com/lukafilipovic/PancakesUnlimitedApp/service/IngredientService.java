package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientResponseDto;

import java.util.List;

public interface IngredientService {
    IngredientResponseDto addIngredient(IngredientDto ingredientDto);
    void deleteIngredient(long id);
    IngredientResponseDto updateIngredient(IngredientDto ingredientDto, long id);
    List<IngredientResponseDto> viewAllIngredients();
}
