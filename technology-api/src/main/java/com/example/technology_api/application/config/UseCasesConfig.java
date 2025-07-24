package com.example.technology_api.application.config;

import com.example.technology_api.domain.spi.TechnologyPersistencePort;
import com.example.technology_api.domain.usecase.TechnologyUseCase;
import com.example.technology_api.domain.api.TechnologyServicePort;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.TechnologyPersistenceAdapter;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.mapper.TechnologyEntityMapper;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCasesConfig {
    private final TechnologyRepository technologyRepository;
    private final TechnologyEntityMapper technologyEntityMapper;

    @Bean
    public TechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyPersistenceAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public TechnologyServicePort technologyServicePort(TechnologyPersistencePort technologyPersistencePort) {
        return new TechnologyUseCase(technologyPersistencePort);
    }
}
