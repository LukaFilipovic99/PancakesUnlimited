package com.lukafilipovic.PancakesUnlimitedApp.payload;

import lombok.Data;

@Data
public class IngredientDto {
    private String name;
    private Double price;
    private Long categoryId;
    private Boolean healthy;
}
