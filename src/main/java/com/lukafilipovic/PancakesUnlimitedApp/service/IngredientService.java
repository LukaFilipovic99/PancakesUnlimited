package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;

import java.util.List;

public interface IngredientService {
    IngredientDto addIngredient(IngredientDto ingredientDto, long category_id);
    void deleteIngredient(long id);
    IngredientDto updateIngredient(IngredientDto ingredientDto, long id);
    List<IngredientDto> viewAllIngredients();
}
