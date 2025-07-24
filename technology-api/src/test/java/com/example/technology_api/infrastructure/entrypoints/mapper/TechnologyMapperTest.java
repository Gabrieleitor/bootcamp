package com.example.technology_api.infrastructure.entrypoints.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.entrypoints.dto.TechnologyDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class TechnologyMapperTest {

    private TechnologyMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(TechnologyMapper.class);
    }

    @Test
    void testTechnologyDTOToTechnology() {
        TechnologyDTO dto = new TechnologyDTO();
        dto.setId(1L);
        dto.setName("Java");
        dto.setDescription("Lenguaje de programación");

        Technology technology = mapper.technologyDTOToTechnology(dto);

        assertNotNull(technology);
        assertEquals(dto.getId(), technology.id());
        assertEquals(dto.getName(), technology.name());
        assertEquals(dto.getDescription(), technology.description());
    }
} 