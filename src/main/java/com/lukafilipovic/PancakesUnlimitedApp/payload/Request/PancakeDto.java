package com.lukafilipovic.PancakesUnlimitedApp.payload;

import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PancakeDto {
    Set<Long> ingredientIds=new HashSet<>();
}
