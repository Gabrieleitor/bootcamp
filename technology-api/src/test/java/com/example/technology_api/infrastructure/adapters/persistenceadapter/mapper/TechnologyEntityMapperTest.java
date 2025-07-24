package com.example.technology_api.infrastructure.adapters.persistenceadapter.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.entity.TechnologyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnologyEntityMapperTest {
    private final TechnologyEntityMapper mapper = new TechnologyEntityMapperImpl();

    @Test
    void testToModel() {
        TechnologyEntity entity = new TechnologyEntity();
        entity.setId(1L);
        entity.setName("Java");
        entity.setDescription("Lenguaje de programación");

        Technology tech = mapper.toModel(entity);
        assertNotNull(tech);
        assertEquals(entity.getId(), tech.id());
        assertEquals(entity.getName(), tech.name());
        assertEquals(entity.getDescription(), tech.description());
    }

    @Test
    void testToEntity() {
        Technology tech = new Technology(2L, "Python", "Lenguaje interpretado");
        TechnologyEntity entity = mapper.toEntity(tech);
        assertNotNull(entity);
        assertEquals(tech.id(), entity.getId());
        assertEquals(tech.name(), entity.getName());
        assertEquals(tech.description(), entity.getDescription());
    }
} 