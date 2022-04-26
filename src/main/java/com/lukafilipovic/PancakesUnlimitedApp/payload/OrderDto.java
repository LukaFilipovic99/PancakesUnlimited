package com.lukafilipovic.PancakesUnlimitedApp.payload;

import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
public class OrderDto {
    private String description;
    private Set<Long> pancakeIds=new HashSet<>();
}
