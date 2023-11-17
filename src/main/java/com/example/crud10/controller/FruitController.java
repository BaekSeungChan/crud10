package com.example.crud10.controller;

import com.example.crud10.payload.FruitDto;
import com.example.crud10.service.FruitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fruit")
@Tag(name = "Fruit API'S")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @PostMapping
    @Operation(
            summary = "Create Fruit",
            description = "Create Fruit API"
    )
    public ResponseEntity<FruitDto> createFruit(@Valid @RequestBody FruitDto fruitDto){
        return new ResponseEntity<>(fruitService.createFruit(fruitDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FruitDto>> getAllFruit(){
        return ResponseEntity.ok(fruitService.getAllFruit());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FruitDto> detailFruitById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(fruitService.detailFruitById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable(name = "id") long id){
        fruitService.deleteFruit(id);
        return ResponseEntity.ok("deleted information");
    }

    @PutMapping("/{id}")
    public ResponseEntity<FruitDto> updateFruit(@PathVariable(name = "id")long id, @Valid @RequestBody FruitDto fruitDto){
        FruitDto saveFruit = fruitService.updateFruit(fruitDto, id);
        return new ResponseEntity<>(saveFruit, HttpStatus.OK);
    }

}
