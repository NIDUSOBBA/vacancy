package com.example.vacancy.event;

import com.example.vacancy.service.VacancySyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class VacancyEventListener {

    private final VacancySyncService vacancySyncService;

    @TransactionalEventListener
    public void handleVacancyCreated(VacancyCreatedEvent event) {
        vacancySyncService.syncVacancy(event.vacancy());
    }

    @TransactionalEventListener
    public void handleVacancyUpdated(VacancyUpdatedEvent event) {
        vacancySyncService.syncVacancy(event.vacancy());
    }

    @TransactionalEventListener
    public void handleVacancyDeleted(VacancyDeletedEvent event) {
        vacancySyncService.deleteFromIndex(event.vacancyId());
    }
}
