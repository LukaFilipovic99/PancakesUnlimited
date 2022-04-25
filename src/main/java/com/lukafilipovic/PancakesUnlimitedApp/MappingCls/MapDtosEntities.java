package com.lukafilipovic.PancakesUnlimitedApp.MappingCls;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeDto;

public class MapDtosEntities {
    public static IngredientDto mapIngredientToDto(Ingredient ingredient){
        IngredientDto ingredientDto=new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setPrice(ingredientDto.getPrice());
        return ingredientDto;
    }

    public static Ingredient mapIngredientToEntity(IngredientDto ingredientDto){
        Ingredient ingredient=new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setPrice(ingredientDto.getPrice());
        return ingredient;
    }

    public static Pancake mapPancakeToEntity(PancakeDto pancakeDto){
        Pancake pancake=new Pancake();
        pancake.setId(pancakeDto.getId());
        for (IngredientDto i : pancakeDto.getPancakeIngredients()){
            Ingredient ingredient= mapIngredientToEntity(i);
            pancake.getPancakeIngredients().add(ingredient);
        }
        return pancake;
    }

    public static PancakeDto mapPancakeToDto(Pancake pancake){
        PancakeDto pancakeDto=new PancakeDto();
        pancakeDto.setId(pancake.getId());
        for (Ingredient i: pancake.getPancakeIngredients()){
            IngredientDto ingredientDto=mapIngredientToDto(i);
            pancakeDto.getPancakeIngredients().add(ingredientDto);
        }
        return pancakeDto;
    }
}
