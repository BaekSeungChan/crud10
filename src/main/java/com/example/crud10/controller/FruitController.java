package com.example.crud10.controller;

import com.example.crud10.payload.FruitDto;
import com.example.crud10.service.FruitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @PostMapping
    public ResponseEntity<FruitDto> createFruit(@Valid @RequestBody FruitDto fruitDto){
        return new ResponseEntity<>(fruitService.createFruit(fruitDto), HttpStatus.OK);
    }

}
