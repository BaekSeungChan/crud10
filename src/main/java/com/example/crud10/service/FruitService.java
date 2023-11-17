package com.example.crud10.service;

import com.example.crud10.payload.FruitDto;

import java.util.List;

public interface FruitService {

    FruitDto createFruit(FruitDto fruitDto);

    List<FruitDto> getAllFruit();

    FruitDto detailFruitById(long id);

    void deleteFruit(long id);

}
