package com.example.vacancy.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record ElasticsearchVacancyPageDto(
        @Min(value = 0,message = "Страница не должна быть отрицательной")
        Integer page,
        @Positive(message = "Количество не должно быть отрицательным")
        Integer size,
        @Pattern(regexp = "^(asc|desc)$",
                flags = Pattern.Flag.CASE_INSENSITIVE,
                message = "Поле sortOrder должно быть \"asc\" или \"desc\"")
        String sort) {
}
