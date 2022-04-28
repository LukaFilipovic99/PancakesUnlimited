package com.lukafilipovic.PancakesUnlimitedApp.payload.Response;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PancakeResponseDto {
    private Long id;
    private Set<IngredientResponseDto> pancakeIngredients= new HashSet();
}
