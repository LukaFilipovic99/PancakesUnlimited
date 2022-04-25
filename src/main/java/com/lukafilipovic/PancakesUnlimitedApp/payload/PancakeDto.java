package com.lukafilipovic.PancakesUnlimitedApp.payload;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PancakeDto {
    private Long id;
    private Set<IngredientDto> pancakeIngredients= new HashSet();
}
