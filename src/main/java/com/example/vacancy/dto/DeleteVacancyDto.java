package com.example.vacancy.dto;

import com.example.vacancy.util.Status;
import lombok.Builder;

@Builder
public record DeleteVacancyDto(Status status,
                               Long id) {
}
