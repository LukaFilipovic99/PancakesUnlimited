package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeResponseDto;

import java.util.List;

public interface PancakeService {
    PancakeResponseDto createPancake(PancakeDto pancakeDto);
    void deletePancake(long id);
    PancakeResponseDto updatePancake(long id, PancakeDto pancakeDto);
    List<PancakeResponseDto> getAllPancakes();
    PancakeResponseDto getPancakeById(long id);
}
