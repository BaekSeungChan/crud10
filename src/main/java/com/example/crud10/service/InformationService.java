package com.example.crud10.service;

import com.example.crud10.entity.Information;
import com.example.crud10.payload.InformationDto;

import java.util.List;

public interface InformationService {

    InformationDto createInformation(InformationDto informationDto);

    List<InformationDto> getAllInformation();

    InformationDto detailInformationById(long id);

    void deleteInformation(long id);
}
