package com.example.technology_api.infrastructure.adapters.persistenceadapter;

import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.domain.spi.TechnologyPersistencePort;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.mapper.TechnologyEntityMapper;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.repository.TechnologyRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class TechnologyPersistenceAdapter implements TechnologyPersistencePort {
    private final TechnologyRepository technologyRepository;
    private final TechnologyEntityMapper technologyEntityMapper;

    @Override
    public Mono<Technology> save(Technology technology) {
        return technologyRepository.save(technologyEntityMapper.toEntity(technology))
                .map(technologyEntityMapper::toModel);
    }

    @Override
    public Mono<Boolean> existByTechnology(String name) {
        return technologyRepository.findByName(name)
                .map(technologyEntityMapper::toModel)
                .map(technology -> true)
                .defaultIfEmpty(false);
    }

}
