package com.example.technology_api.infrastructure.entrypoints.mapper;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.infrastructure.entrypoints.dto.TechnologyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    default Technology technologyDTOToTechnology(TechnologyDTO dto) {
        return dto == null ? null :
                new Technology(dto.getId(), dto.getName(), dto.getDescription());
    }
}
