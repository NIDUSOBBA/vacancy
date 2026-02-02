package com.example.vacancy.dto;

import lombok.Builder;

@Builder
public record VacancyDocumentDto(String name,
                                 String description,
                                 String company,
                                 String location,
                                 Integer salary,
                                 String workExperience,
                                 Integer weight) {
}
