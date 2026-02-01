package com.example.vacancy.dto;

public record DeleteVacancyDto(String status,
                               Integer id,
                               String nameVacancy,
                               String fieldActivity,
                               String description) {
    public DeleteVacancyDto {
        status = "Ликвидирован";
    }
}
