package com.example.crud10.service;

import com.example.crud10.entity.Information;
import com.example.crud10.payload.InformationDto;

public interface InformationService {

    InformationDto createInformation(InformationDto informationDto);
}
