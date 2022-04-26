package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.MappingCls.MapDtosEntities;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.PancakeApiException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.PancakeResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.IngredientRepository;
import com.lukafilipovic.PancakesUnlimitedApp.repository.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PancakeServiceImplementation implements PancakeService{
    private PancakeRepository pancakeRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public PancakeServiceImplementation(PancakeRepository pancakeRepository, IngredientRepository ingredientRepository) {
        this.pancakeRepository = pancakeRepository;
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public PancakeResponseDto createPancake(PancakeDto pancakeDto) {
        int numOfBazaIngredients=0;
        int numOfNadjevIngredients=0;
        Pancake pancake = new Pancake();
        Pancake newPancake;
        for (Long id: pancakeDto.getIngredientIds()){
            Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IdNotFoundException("Ingredient Id not found!"));
            pancake.getPancakeIngredients().add(ingredient);
            if(ingredient.getCategory().getId()==1) numOfBazaIngredients++;
            if (ingredient.getCategory().getId()==2) numOfNadjevIngredients++;
        }
        if (numOfBazaIngredients==1 && numOfNadjevIngredients>=1){
            newPancake=pancakeRepository.save(pancake);
        }else throw new PancakeApiException("Pancake must contain 1 BAZA ingredient and 1 or more NADJEV ingredients");
        return MapDtosEntities.mapPancakeToDto(newPancake);
    }

    @Override
    public void deletePancake(long id) {
        Pancake pancake=pancakeRepository.findById(id).orElseThrow(()->new IdNotFoundException("Pancake Id not found"));
        Set<Ingredient> ingredientsToRemove=new HashSet<>();
        for (Ingredient i: pancake.getPancakeIngredients()){
            ingredientsToRemove.add(i);
        }
        pancake.getPancakeIngredients().removeAll(ingredientsToRemove);
        for (Ingredient i: ingredientsToRemove) {
            i.getPancakes().remove(pancake);
        }
        pancakeRepository.delete(pancake);
    }

    @Override
    public PancakeResponseDto updatePancake(long id, PancakeDto pancakeDto) {
        Pancake pancake=pancakeRepository.findById(id).orElseThrow(()->new IdNotFoundException("Pancake Id not found"));

        Pancake updatedPancake;
        int numOfBazaIngredients=0;
        int numOfNadjevIngredients=0;
        pancake.getPancakeIngredients().clear();
        for (Long ingId: pancakeDto.getIngredientIds()){
            Ingredient ingredient=ingredientRepository.findById(ingId).orElseThrow(()->new IdNotFoundException("Ingredient Id not found!"));
            pancake.getPancakeIngredients().add(ingredient);
            if(ingredient.getCategory().getId()==1) numOfBazaIngredients++;
            if (ingredient.getCategory().getId()==2) numOfNadjevIngredients++;
        }
        if (numOfBazaIngredients==1 && numOfNadjevIngredients>=1){
            updatedPancake=pancakeRepository.save(pancake);
        }else throw new PancakeApiException("Pancake must contain 1 BAZA ingredient and 1 or more NADJEV ingredients");
        return MapDtosEntities.mapPancakeToDto(updatedPancake);
    }

    @Override
    public List<PancakeResponseDto> getAllPancakes() {
        List<Pancake> pancakes=pancakeRepository.findAll();
        List<PancakeResponseDto> pancakeResponseDtos =new ArrayList<>();
        for (Pancake pancake: pancakes){
            pancakeResponseDtos.add(MapDtosEntities.mapPancakeToDto(pancake));
        }
        return pancakeResponseDtos;
    }

    @Override
    public PancakeResponseDto getPancakeById(long id) {
        Pancake pancake=pancakeRepository.findById(id).orElseThrow(()->new IdNotFoundException("Pancake Id not found"));
        return MapDtosEntities.mapPancakeToDto(pancake);
    }


}
