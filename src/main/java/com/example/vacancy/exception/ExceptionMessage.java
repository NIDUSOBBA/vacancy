package com.example.vacancy.exception;

import lombok.Builder;

@Builder
public record ExceptionMessage(String errorClassName,
                               String message,
                               String stackTrace,
                               String rootCause) {
}
