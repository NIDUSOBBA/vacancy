package com.example.vacancy.util;

import com.example.vacancy.service.ElasticsearchVacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

    private final ElasticsearchVacancyService elasticsearchVacancyService;

    @EventListener(ApplicationReadyEvent.class)
    public void syncVacanciesOnStartup() {
        log.info("Start syncing vacancies");
        try {
            elasticsearchVacancyService.saveAll();
            log.info("Vacancies synchronization completed successfully");
        }catch (Exception e){
            log.error("Failed to synchronize vacancies: {}", e.getMessage());
        }
    }
}
