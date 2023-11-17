package com.example.crud10.service.Impl;

import com.example.crud10.entity.Fruit;
import com.example.crud10.entity.Information;
import com.example.crud10.payload.FruitDto;
import com.example.crud10.payload.InformationDto;
import com.example.crud10.repository.InfromationRepository;
import com.example.crud10.service.InformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationServiceImpl implements InformationService {
    private InfromationRepository infromationRepository;

    private ModelMapper modelMapper;

    public InformationServiceImpl(InfromationRepository infromationRepository, ModelMapper modelMapper){
        this.infromationRepository = infromationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InformationDto createInformation(InformationDto informationDto){
        Information information = modelMapper.map(informationDto, Information.class);
        Information saveInformation = infromationRepository.save(information);

        return modelMapper.map(saveInformation, InformationDto.class);
    }

    @Override
    public List<InformationDto> getAllInformation(){
        List<Information> informations = infromationRepository.findAll();
        return informations.stream().map((information) -> modelMapper.map(information, InformationDto.class)).collect(Collectors.toList());
    }

    @Override
    public InformationDto detailInformationById(long id){
        Information information = infromationRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(information, InformationDto.class);
    }

    @Override
    public void deleteInformation(long id){
        Information information = infromationRepository.findById(id).orElseThrow(()-> new RuntimeException("No id"));
        infromationRepository.delete(information);
    }

    @Override
    public InformationDto updateInformation(InformationDto informationDto, long id){
        Information information = infromationRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        information.setDescription(informationDto.getDescription());
        information.setPrice(informationDto.getPrice());

        Information saveInformation = infromationRepository.save(information);

        return modelMapper.map(saveInformation, InformationDto.class);
    }

}
