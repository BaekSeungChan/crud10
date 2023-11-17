package com.example.crud10.payload;

import lombok.Data;

@Data
public class InformationDto {
    private Long id;
    private String description;
    private Integer price;
}