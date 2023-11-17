package com.example.crud10.payload;

import com.example.crud10.entity.Information;
import lombok.Data;

@Data
public class FruitDto {
    private Long id;
    private String name;

    private Long fruitId;
}
