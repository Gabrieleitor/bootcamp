package com.example.technology_api.infrastructure.adapters.persistenceadapter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "technologys")
@Data
public class TechnologyEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
