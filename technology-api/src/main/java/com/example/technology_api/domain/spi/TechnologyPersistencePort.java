package com.example.technology_api.domain.spi;

import com.example.technology_api.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface TechnologyPersistencePort {
    Mono<Technology> save(Technology technology);
    Mono<Boolean> existByTechnology(String description);
}
