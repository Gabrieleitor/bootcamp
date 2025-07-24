package com.example.technology_api.infrastructure.adapters.persistenceadapter.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnologyEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    Technology toModel(TechnologyEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    TechnologyEntity toEntity(Technology technology);
}