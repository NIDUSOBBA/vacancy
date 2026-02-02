package com.example.vacancy.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    private ExceptionMessage exceptionWriter(Exception exception) {
        return ExceptionMessage.builder()
                .errorClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exceptionWriter(exception);
    }

    @ExceptionHandler(VacancyNotFound.class)
    public ExceptionMessage handleVacancyNotFound(VacancyNotFound vacancyNotFound) {
        return exceptionWriter(vacancyNotFound);
    }

}
