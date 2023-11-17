package com.example.crud10.controller;

import com.example.crud10.payload.InformationDto;
import com.example.crud10.service.InformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/information")
public class InformationController {
    private InformationService informationService;

    public InformationController(InformationService informationService){
        this.informationService = informationService;
    }

    @PostMapping
    public ResponseEntity<InformationDto> createInformation(@Valid @RequestBody InformationDto informationDto){
        return new ResponseEntity<>(informationService.createInformation(informationDto), HttpStatus.OK);
    }
}
