package com.example.crud10.controller;

import com.example.crud10.payload.FruitDto;
import com.example.crud10.payload.InformationDto;
import com.example.crud10.service.InformationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<InformationDto>> getAllInformation(){
        return ResponseEntity.ok(informationService.getAllInformation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformationDto> detailInformationById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(informationService.detailInformationById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInformation(@PathVariable(name = "id") long id){
        informationService.deleteInformation(id);
        return ResponseEntity.ok("deleted information");
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformationDto> updateInformation(@PathVariable(name = "id") long id, @Valid @RequestBody InformationDto informationDto){
        InformationDto InformationResponse = informationService.updateInformation(informationDto, id);
        return new ResponseEntity<>(InformationResponse, HttpStatus.OK);
    }

}
