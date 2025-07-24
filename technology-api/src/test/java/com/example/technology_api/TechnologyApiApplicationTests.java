package com.example.technology_api;

import com.example.technology_api.domain.spi.TechnologyPersistencePort;
import com.example.technology_api.infrastructure.adapters.persistenceadapter.repository.TechnologyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TechnologyApiApplication.class)
@ActiveProfiles("test")
class TechnologyApiApplicationTests {

	@MockBean
	private TechnologyRepository technologyRepository;

	@MockBean
	private TechnologyPersistencePort technologyPersistencePort;


	@Test
	void contextLoads() {
	}

}
