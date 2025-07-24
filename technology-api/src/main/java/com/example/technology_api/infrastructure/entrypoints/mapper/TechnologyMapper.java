package com.example.technology_api.infrastructure.entrypoints.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.entrypoints.dto.TechnologyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    Technology technologyDTOToTechnology(TechnologyDTO technologyDTO);
}
