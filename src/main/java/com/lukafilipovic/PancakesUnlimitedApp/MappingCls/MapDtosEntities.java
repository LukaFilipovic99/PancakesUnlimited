package com.lukafilipovic.PancakesUnlimitedApp.MappingCls;

import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.Order;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.*;

import java.util.Map;

public class MapDtosEntities {
    public static IngredientResponseDto mapIngredientToDto(Ingredient ingredient){
        IngredientResponseDto ingredientResponseDto =new IngredientResponseDto();
        ingredientResponseDto.setId(ingredient.getId());
        ingredientResponseDto.setName(ingredient.getName());
        ingredientResponseDto.setPrice(ingredient.getPrice());
        ingredientResponseDto.setCategory(ingredient.getCategory().getName());
        ingredientResponseDto.setHealthy(ingredient.getHealthy());
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

    public static PancakeResponseWithPriceDto mapPancakeWithPriceToDto(Pancake pancake, double pancakePrice){
        PancakeResponseWithPriceDto pancakeResponseWithPriceDto=new PancakeResponseWithPriceDto();
        pancakeResponseWithPriceDto.setId(pancake.getId());
        pancakeResponseWithPriceDto.setPrice(pancakePrice);
        for (Ingredient i:pancake.getPancakeIngredients()){
            pancakeResponseWithPriceDto.getPancakeIngredients().add(mapIngredientToDto(i));
        }
        return pancakeResponseWithPriceDto;
    }

    public static OrderResponseWithPriceDto mapOrderWithPriceToDto(Order order, double orderPrice, Map<Pancake,Double> pancakePrices){
        OrderResponseWithPriceDto orderResponseWithPriceDto=new OrderResponseWithPriceDto();
        orderResponseWithPriceDto.setId(order.getId());
        orderResponseWithPriceDto.setDescription(order.getDescription());
        orderResponseWithPriceDto.setTime(order.getTime());
        orderResponseWithPriceDto.setPrice(orderPrice);
        for (Pancake p: pancakePrices.keySet()){
            orderResponseWithPriceDto.getListOfPancakes().add(mapPancakeWithPriceToDto(p, pancakePrices.get(p)));
        }
        return orderResponseWithPriceDto;
        }
    }
