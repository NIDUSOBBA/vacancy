package com.example.vacancy.event;

import com.example.vacancy.service.ElasticsearchVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class VacancyEventListener {

    private final ElasticsearchVacancyService elasticsearchVacancyService;

    @TransactionalEventListener
    public void handleCreated(VacancyCreatedEvent event) {
        elasticsearchVacancyService.save(event.vacancy());
    }

    @TransactionalEventListener
    public void handleUpdated(VacancyUpdatedEvent event) {
        elasticsearchVacancyService.save(event.vacancy());
    }

    @TransactionalEventListener
    public void handleDeleted(VacancyDeletedEvent event) {
        elasticsearchVacancyService.deleteFromIndex(event.vacancyId());
    }
}
