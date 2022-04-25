package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeDto;

import java.util.List;

public interface PancakeService {
    PancakeDto createPancake(List<Long> ingredientIds);
    void deletePancake(long id);
    PancakeDto updatePancake(long id, List<Long> ingredientIds);
    List<PancakeDto> getAllPancakes();
    PancakeDto getPancakeById(long id);
}
