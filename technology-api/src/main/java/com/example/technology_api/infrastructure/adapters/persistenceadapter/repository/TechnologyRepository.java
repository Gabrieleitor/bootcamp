package com.example.technology_api.infrastructure.adapters.persistenceadapter.repository;

import com.example.technology_api.infrastructure.adapters.persistenceadapter.entity.TechnologyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface TechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, Long> {
    Mono<TechnologyEntity> findByName(String name);
}
