package com.example.technology_api.infrastructure.entrypoints.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TechnologyDTO {
    private Long id;
    private String name;
    private String description;
}
