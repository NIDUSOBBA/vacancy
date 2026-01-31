package com.example.vacancy.util;

import com.example.vacancy.service.VacancySyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final VacancySyncService vacancySyncService;

    @Override
    public void run(String... args) throws Exception {
        vacancySyncService.syncAllVacancies();
    }
    //Генна на
}
