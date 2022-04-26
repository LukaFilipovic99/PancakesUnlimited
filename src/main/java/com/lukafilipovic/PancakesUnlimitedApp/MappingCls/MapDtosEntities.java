package com.lukafilipovic.PancakesUnlimitedApp.MappingCls;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.Order;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.IngredientResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeResponseDto;

public class MapDtosEntities {
    public static IngredientResponseDto mapIngredientToDto(Ingredient ingredient){
        IngredientResponseDto ingredientResponseDto =new IngredientResponseDto();
        ingredientResponseDto.setId(ingredient.getId());
        ingredientResponseDto.setName(ingredient.getName());
        ingredientResponseDto.setPrice(ingredient.getPrice());
        ingredientResponseDto.setCategory(ingredient.getCategory().getName());
        return ingredientResponseDto;
    }

    public static PancakeResponseDto mapPancakeToDto(Pancake pancake){
        PancakeResponseDto pancakeResponseDto =new PancakeResponseDto();
        pancakeResponseDto.setId(pancake.getId());
        for (Ingredient i: pancake.getPancakeIngredients()){
            IngredientResponseDto ingredientResponseDto =mapIngredientToDto(i);
            pancakeResponseDto.getPancakeIngredients().add(ingredientResponseDto);
        }
        return pancakeResponseDto;
    }


    public static OrderResponseDto mapOrderToDto(Order order){
        OrderResponseDto orderResponseDto =new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDescription(order.getDescription());
        orderResponseDto.setTime(order.getTime());
        for (Pancake p:order.getListOfPancakes()){
            PancakeResponseDto pancakeResponseDto =mapPancakeToDto(p);
            orderResponseDto.getListOfPancakes().add(pancakeResponseDto);
        }
        return orderResponseDto;
    }
}
