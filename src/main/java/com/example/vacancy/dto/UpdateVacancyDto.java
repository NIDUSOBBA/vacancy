package com.example.vacancy.dto;

public record UpdateVacancyDto(Long id,
                               String name,
                               String description,
                               Integer salary) {
}
