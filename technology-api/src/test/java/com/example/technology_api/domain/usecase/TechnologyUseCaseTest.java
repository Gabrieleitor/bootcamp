package com.example.technology_api.domain.usecase;

import com.example.technology_api.domain.enums.TechnicalMessage;
import com.example.technology_api.domain.exceptions.BusinessException;
import com.example.technology_api.domain.model.Technology;
import com.example.technology_api.domain.spi.TechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TechnologyUseCaseTest {
    private TechnologyPersistencePort persistencePort;
    private TechnologyUseCase useCase;

    @BeforeEach
    void setUp() {
        persistencePort = mock(TechnologyPersistencePort.class);
        useCase = new TechnologyUseCase(persistencePort);
        when(persistencePort.existByTechnology(any())).thenReturn(Mono.just(false));
    }

    @Test
    void shouldReturnErrorWhenNameIsNull() {
        Technology tech = new Technology(1L, null, "desc");
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectErrorSatisfies(e -> {
                    assertTrue(e instanceof BusinessException);
                    assertEquals(TechnicalMessage.TECHNOLOGY_NAME_REQUIRED, ((BusinessException) e).getTechnicalMessage());
                })
                .verify();
    }

    @Test
    void shouldReturnErrorWhenDescriptionIsNull() {
        Technology tech = new Technology(1L, "Java", null);
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectErrorSatisfies(e -> {
                    assertTrue(e instanceof BusinessException);
                    assertEquals(TechnicalMessage.TECHNOLOGY_DESCRIPTION_REQUIRED, ((BusinessException) e).getTechnicalMessage());
                })
                .verify();
    }

    @Test
    void shouldReturnErrorWhenNameTooLong() {
        String longName = "a".repeat(51);
        Technology tech = new Technology(1L, longName, "desc");
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectErrorSatisfies(e -> {
                    assertTrue(e instanceof BusinessException);
                    assertEquals(TechnicalMessage.TECHNOLOGY_NAME_TOO_LONG, ((BusinessException) e).getTechnicalMessage());
                })
                .verify();
    }

    @Test
    void shouldReturnErrorWhenDescriptionTooLong() {
        String longDesc = "a".repeat(91);
        Technology tech = new Technology(1L, "Java", longDesc);
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectErrorSatisfies(e -> {
                    assertTrue(e instanceof BusinessException);
                    assertEquals(TechnicalMessage.TECHNOLOGY_DESCRIPTION_TOO_LONG, ((BusinessException) e).getTechnicalMessage());
                })
                .verify();
    }

    @Test
    void shouldReturnErrorWhenTechnologyAlreadyExists() {
        Technology tech = new Technology(1L, "Java", "desc");
        when(persistencePort.existByTechnology(anyString())).thenReturn(Mono.just(true));
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectErrorSatisfies(e -> {
                    assertTrue(e instanceof BusinessException);
                    assertEquals(TechnicalMessage.TECHNOLOGY_ALREADY_EXISTS, ((BusinessException) e).getTechnicalMessage());
                })
                .verify();
    }

    @Test
    void shouldSaveTechnologySuccessfully() {
        Technology tech = new Technology(1L, "Java", "desc");
        when(persistencePort.existByTechnology(anyString())).thenReturn(Mono.just(false));
        when(persistencePort.save(any(Technology.class))).thenReturn(Mono.just(tech));
        StepVerifier.create(useCase.registerTechnology(tech, "msgId"))
                .expectNext(tech)
                .verifyComplete();
    }
} 