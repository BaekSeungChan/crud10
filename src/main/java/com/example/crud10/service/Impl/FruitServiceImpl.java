package com.example.crud10.service.Impl;

import com.example.crud10.entity.Fruit;
import com.example.crud10.entity.Information;
import com.example.crud10.payload.FruitDto;
import com.example.crud10.repository.FruitRepository;
import com.example.crud10.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<FruitDto> getAllFruit(){
        List<Fruit> fruits = fruitRepository.findAll();

        return fruits.stream().map((fruit) -> modelMapper.map(fruit, FruitDto.class)).collect(Collectors.toList());

    }

    @Override
    public FruitDto detailFruitById(long id){
        Fruit fruit  = fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(fruit, FruitDto.class);
    }

    @Override
    public void deleteFruit(long id){
        Fruit fruit = fruitRepository.findById(id).orElseThrow(()-> new RuntimeException("No id"));
        fruitRepository.delete(fruit);
    }

    @Override
    public FruitDto updateFruit(FruitDto fruitDto, long id){
        Fruit fruit = fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        fruit.setName(fruitDto.getName());

        Fruit saveFruit = fruitRepository.save(fruit);

        return modelMapper.map(saveFruit, FruitDto.class);

    }
}
