package com.example.technology_api.infrastructure.adapters.persistenceadapter.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.entity.TechnologyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyEntityMapper {
    default Technology toModel(TechnologyEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Technology(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    default TechnologyEntity toEntity(Technology technology) {
        if (technology == null) {
            return null;
        }
        TechnologyEntity entity = new TechnologyEntity();
        entity.setId(technology.id());
        entity.setName(technology.name());
        entity.setDescription(technology.description());
        return entity;
    }
}