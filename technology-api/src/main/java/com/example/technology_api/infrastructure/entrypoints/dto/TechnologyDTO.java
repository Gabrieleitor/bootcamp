package com.example.technology_api.infrastructure.entrypoints.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDTO {
    private Long id;
    private String name;
    private String description;
}
