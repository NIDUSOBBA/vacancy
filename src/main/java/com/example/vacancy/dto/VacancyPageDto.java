package com.example.vacancy.dto;

import jakarta.validation.constraints.Positive;

public record VacancyPageDto(
        @Positive(message = "Страница не должна быть отрицательной")
        Integer page,
        @Positive(message = "Количество не должно быть отрицательным")
        Integer size) {
}
