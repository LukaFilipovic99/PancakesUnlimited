package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.MappingCls.MapDtosEntities;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.IngredientCategory;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.IngredientResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientCategoryRepository;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImplementation implements IngredientService{
    private IngredientRepository ingredientRepository;
    private IngredientCategoryRepository categoryRepository;

    @Autowired
    public IngredientServiceImplementation(IngredientRepository ingredientRepository, IngredientCategoryRepository categoryRepository) {
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public IngredientResponseDto addIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient=new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        ingredient.setHealthy(ingredientDto.getHealthy());
        IngredientCategory category=categoryRepository.findById(ingredientDto.getCategoryId()).orElseThrow(()->new IdNotFoundException("Category Id not found."));
        ingredient.setCategory(category);
        Ingredient newIngredient=ingredientRepository.save(ingredient);
        return MapDtosEntities.mapIngredientToDto(newIngredient);
    }

    @Override
    public void deleteIngredient(long id) {
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found."));
        ingredientRepository.delete(ingredient);
    }

    @Override
    public IngredientResponseDto updateIngredient(IngredientDto ingredientDto, long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found."));
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        ingredient.setHealthy(ingredientDto.getHealthy());
        IngredientCategory category=categoryRepository.findById(ingredientDto.getCategoryId()).orElseThrow(()->new IdNotFoundException("Category Id not found."));
        ingredient.setCategory(category);
        Ingredient updatedIngredient=ingredientRepository.save(ingredient);
        return MapDtosEntities.mapIngredientToDto(updatedIngredient);
    }

    @Override
    public List<IngredientResponseDto> viewAllIngredients() {
        List<Ingredient> ingredients=ingredientRepository.findAll();
        List<IngredientResponseDto> ingredientResponseDtos =new ArrayList<>();
        for (Ingredient i:ingredients) {
            ingredientResponseDtos.add(MapDtosEntities.mapIngredientToDto(i));
        }
        return ingredientResponseDtos;
    }
}
