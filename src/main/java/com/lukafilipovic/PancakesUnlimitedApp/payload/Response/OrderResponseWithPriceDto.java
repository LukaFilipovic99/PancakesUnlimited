package com.lukafilipovic.PancakesUnlimitedApp.payload.Response;

import lombok.Data;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderResponseWithPriceDto {
    private Long id;
    private String description;
    private LocalTime time;
    private Double price;
    private Set<PancakeResponseWithPriceDto> listOfPancakes=new HashSet<>();
}
