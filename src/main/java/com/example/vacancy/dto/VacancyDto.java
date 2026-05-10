package com.example.vacancy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record VacancyDto(

        @NotBlank(message = "Название вакансии обязательно")
        String name,
        @NotBlank(message = "Описание вакансии обязательно")
        String description,
        @NotBlank(message = "Название компании обязательно")
        String company,
        @NotBlank(message = "Расположение компании обязательно")
        String location,
        @Positive(message = "Зарплата должна быть положительной")
        Integer salary,
        String workExperience) {
}
