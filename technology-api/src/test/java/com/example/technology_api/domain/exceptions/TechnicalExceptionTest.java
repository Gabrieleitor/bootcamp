package com.example.technology_api.domain.exceptions;

import com.example.technology_api.domain.enums.TechnicalMessage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnicalExceptionTest {

    @Test
    void shouldCreateTechnicalExceptionWithMessage() {
        TechnicalException ex = new TechnicalException(TechnicalMessage.INTERNAL_ERROR);
        assertEquals(TechnicalMessage.INTERNAL_ERROR, ex.getTechnicalMessage());
        assertEquals(TechnicalMessage.INTERNAL_ERROR.getMessage(), ex.getMessage());
    }

    @Test
    void shouldCreateTechnicalExceptionWithCauseAndMessage() {
        Throwable cause = new RuntimeException("Causa original");
        TechnicalException ex = new TechnicalException(cause, TechnicalMessage.INTERNAL_ERROR_IN_ADAPTERS);
        assertEquals(TechnicalMessage.INTERNAL_ERROR_IN_ADAPTERS, ex.getTechnicalMessage());
        assertEquals(cause, ex.getCause());
    }
} 