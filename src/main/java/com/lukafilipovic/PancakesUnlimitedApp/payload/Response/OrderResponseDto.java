package com.lukafilipovic.PancakesUnlimitedApp.payload.Response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderResponseDto {
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    private Set<PancakeResponseDto> listOfPancakes=new HashSet<>();
}
