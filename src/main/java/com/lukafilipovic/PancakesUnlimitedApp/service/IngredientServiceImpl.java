package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.IngredientCategory;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientCategoryRepository;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService{
    private IngredientRepository ingredientRepository;
    private IngredientCategoryRepository categoryRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientCategoryRepository categoryRepository) {
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
    }

    private IngredientDto mapToDto(Ingredient ingredient){
        IngredientDto ingredientDto=new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setPrice(ingredientDto.getPrice());
        return ingredientDto;
    }

    private Ingredient mapToEntity(IngredientDto ingredientDto){
        Ingredient ingredient=new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        return ingredient;
    }

    @Override
    public IngredientDto addIngredient(IngredientDto ingredientDto, long categoryId) {
        Ingredient ingredient=mapToEntity(ingredientDto);
        IngredientCategory category=categoryRepository.findById(categoryId).orElseThrow(()->new IdNotFoundException("Category Id not found."));
        ingredient.setCategory(category);
        Ingredient newIngredient=ingredientRepository.save(ingredient);
        return mapToDto(newIngredient);
    }

    @Override
    public void deleteIngredient(long id) {
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found."));
        ingredientRepository.delete(ingredient);
    }

    @Override
    public IngredientDto updateIngredient(IngredientDto ingredientDto, long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found."));
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        Ingredient updatedIngredient=ingredientRepository.save(ingredient);
        return mapToDto(updatedIngredient);
    }
}
