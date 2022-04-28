package com.lukafilipovic.PancakesUnlimitedApp.payload.Request;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderDto {
    private String description;
    @NotEmpty(message = "You must add pancakes to the order.")
    private Set<Long> pancakeIds=new HashSet<>();
}
