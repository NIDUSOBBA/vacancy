package com.example.vacancy.event;

import com.example.vacancy.entity.Vacancy;

public record VacancyCreatedEvent(Vacancy vacancy) {
}
