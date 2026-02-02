package com.example.vacancy.exception;

public class VacancyNotFound extends RuntimeException {

    private static final String MESSAGE = "User with id not found: ";
    private final Long id;

    public VacancyNotFound(Long id) {
        this.id=id;
    }

    @Override
    public String getMessage() {
        return MESSAGE + id;
    }

}
