package com.lukafilipovic.PancakesUnlimitedApp.payload;

import lombok.Data;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private Double price;
}
