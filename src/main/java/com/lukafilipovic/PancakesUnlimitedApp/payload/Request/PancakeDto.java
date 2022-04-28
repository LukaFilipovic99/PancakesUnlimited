package com.lukafilipovic.PancakesUnlimitedApp.payload.Request;

import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
public class PancakeDto {
    @NotEmpty(message = "You must add ingredients to the pancake.")
    Set<Long> ingredientIds=new HashSet<>();
}
