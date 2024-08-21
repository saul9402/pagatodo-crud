package com.pagatodo.crud.exception.model;

import java.time.LocalDateTime;

public record GenericErrorResponse(
        String message,
        String detail,
        LocalDateTime datetime
)
{}
