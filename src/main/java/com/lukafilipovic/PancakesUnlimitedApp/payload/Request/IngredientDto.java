package com.lukafilipovic.PancakesUnlimitedApp.payload.Request;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {
    @NotEmpty(message = "Name field cannot be empty.")
    private String name;
    @NotNull(message = "You must enter price for ingredient.")
    @DecimalMin(value = "0.0", message = "Price must be greater than zero")
    private double price;
    @NotNull(message = "You must enter ingredient category.")
    private Long categoryId;
    @NotNull(message = "You must enter true or false.")
    private Boolean healthy;
}
