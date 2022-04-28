package com.lukafilipovic.PancakesUnlimitedApp.payload;

import lombok.Data;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderResponseDto {
    private Long id;
    private String description;
    private LocalTime time;
    private Set<PancakeResponseDto> listOfPancakes=new HashSet<>();
}
