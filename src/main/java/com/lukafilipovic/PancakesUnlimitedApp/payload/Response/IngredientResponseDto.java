package com.lukafilipovic.PancakesUnlimitedApp.payload.Response;

import lombok.Data;

@Data
public class IngredientResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private Boolean healthy;
}
