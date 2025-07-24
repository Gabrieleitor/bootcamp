package com.example.technology_api.domain.usecase;

import com.example.technology_api.domain.api.TechnologyServicePort;
import com.example.technology_api.domain.enums.TechnicalMessage;
import com.example.technology_api.domain.exceptions.BusinessException;
import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.domain.spi.TechnologyPersistencePort;
import reactor.core.publisher.Mono;

public class TechnologyUseCase implements TechnologyServicePort {

    private final TechnologyPersistencePort technologyPersistencePort;


    public TechnologyUseCase(TechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }
    @Override
    public Mono<Technology> registerTechnology(Technology technology, String messageId) {
        return validateTechnology(technology)
            .then(technologyPersistencePort.existByTechnology(technology.name()))
            .filter(exists -> !exists)
            .switchIfEmpty(Mono.error(new BusinessException(TechnicalMessage.TECHNOLOGY_ALREADY_EXISTS)))
            .map(exists -> technology)
            .flatMap(technologyPersistencePort::save);
    }
    
    private Mono<Void> validateTechnology(Technology technology) {
        if (technology.description() == null || technology.description().isBlank()) {
            return Mono.error(new BusinessException(TechnicalMessage.TECHNOLOGY_DESCRIPTION_REQUIRED));
        }
        if (technology.name() == null || technology.name().isBlank()) {
            return Mono.error(new BusinessException(TechnicalMessage.TECHNOLOGY_NAME_REQUIRED));
        }
        if (technology.name().length() > 50) {
            return Mono.error(new BusinessException(TechnicalMessage.TECHNOLOGY_NAME_TOO_LONG));
        }
        if (technology.description().length() > 90) {
            return Mono.error(new BusinessException(TechnicalMessage.TECHNOLOGY_DESCRIPTION_TOO_LONG));
        }
        return Mono.empty();
    }
}