package com.example.vacancy.exception;

public class VacancyNotFound extends RuntimeException {

    private static final String MESSAGE = "User with id not found: ";
    private Integer id;

    public VacancyNotFound(Integer id) {
        this.id=id;
    }

    @Override
    public String getMessage() {
        return MESSAGE + id;
    }
    //Генна на
}
