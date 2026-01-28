package com.example.vacancy.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    private Map<String, String> exceptionWriter(Exception exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getClass().getSimpleName());
        errors.put("message", exception.getMessage());
        return errors;
    }

    @ExceptionHandler(VacancyNotFound.class)
    public Map<String, String> handleVacancyNotFound(VacancyNotFound vacancyNotFound) {
        return exceptionWriter(vacancyNotFound);
    }

}
