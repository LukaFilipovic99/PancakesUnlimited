package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.MappingCls.MapDtosEntities;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.IngredientCategory;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;
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
    public IngredientDto addIngredient(IngredientDto ingredientDto, long categoryId) {
        Ingredient ingredient= MapDtosEntities.mapIngredientToEntity(ingredientDto);
        IngredientCategory category=categoryRepository.findById(categoryId).orElseThrow(()->new IdNotFoundException("Category Id not found."));
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
    public IngredientDto updateIngredient(IngredientDto ingredientDto, long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found."));
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        Ingredient updatedIngredient=ingredientRepository.save(ingredient);
        return MapDtosEntities.mapIngredientToDto(updatedIngredient);
    }

    @Override
    public List<IngredientDto> viewAllIngredients() {
        List<Ingredient> ingredients=ingredientRepository.findAll();
        List<IngredientDto> ingredientDtos=new ArrayList<>();
        for (Ingredient i:ingredients) {
            ingredientDtos.add(MapDtosEntities.mapIngredientToDto(i));
        }
        return ingredientDtos;
    }
}
