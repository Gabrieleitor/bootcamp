package com.example.technology_api.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TechnicalMessage {

    INTERNAL_ERROR("500","Something went wrong, please try again", ""),
    INTERNAL_ERROR_IN_ADAPTERS("PRC501","Something went wrong in adapters, please try again", ""),
    INVALID_REQUEST("400", "Bad Request, please verify data", ""),
    INVALID_PARAMETERS(INVALID_REQUEST.getCode(), "Bad Parameters, please verify data", ""),
    INVALID_MESSAGE_ID("404", "Invalid Message ID, please verify", "messageId"),
    UNSUPPORTED_OPERATION("501", "Method not supported, please try again", ""),
    TECHNOLOGY_CREATED("201", "Technology created successfully", ""),
    ADAPTER_RESPONSE_NOT_FOUND("404-0", "invalid description, please verify", ""),
    TECHNOLOGY_ALREADY_EXISTS("400","The technology is already registered." ,"" ),
    TECHNOLOGY_NAME_REQUIRED("400", "Technology name is required", "name"),
    TECHNOLOGY_NAME_TOO_LONG("400", "Technology name cannot be longer than 50 characters", "name"),
    TECHNOLOGY_DESCRIPTION_REQUIRED("400", "Technology description is required", "description"),
    TECHNOLOGY_DESCRIPTION_TOO_LONG("400", "Technology description cannot be longer than 90 characters", "description");

    private final String code;
    private final String message;
    private final String param;
}