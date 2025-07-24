package com.example.technology_api.domain.api;

import com.example.technology_api.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface TechnologyServicePort {
    Mono<Technology> registerTechnology(Technology technology, String messageId);
}
