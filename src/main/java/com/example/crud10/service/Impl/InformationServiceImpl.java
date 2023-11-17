package com.example.crud10.service.Impl;

import com.example.crud10.entity.Information;
import com.example.crud10.payload.InformationDto;
import com.example.crud10.repository.InfromationRepository;
import com.example.crud10.service.InformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
