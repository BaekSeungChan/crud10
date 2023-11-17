package com.example.crud10.service.Impl;

import com.example.crud10.entity.Fruit;
import com.example.crud10.payload.FruitDto;
import com.example.crud10.repository.FruitRepository;
import com.example.crud10.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;
    private final ModelMapper modelMapper;

    public FruitServiceImpl(FruitRepository fruitRepository, ModelMapper modelMapper){
        this.fruitRepository = fruitRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FruitDto createFruit(FruitDto fruitDto){
        Fruit fruit = modelMapper.map(fruitDto, Fruit.class);
        Fruit saveFruit = fruitRepository.save(fruit);

        return modelMapper.map(saveFruit, FruitDto.class);
    }

}
