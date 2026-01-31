package com.example.vacancy.service;

import com.example.vacancy.entity.VacancyDocument;
import com.example.vacancy.mapper.VacancyDocumentMapper;
import com.example.vacancy.repository.VacancyRepository;
import com.example.vacancy.repository.VacancySearchRepository;
import com.example.vacancy.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VacancySyncService {

    private final VacancySearchRepository vacancySearchRepository;
    private final VacancyRepository vacancyRepository;
    private final VacancyDocumentMapper vacancyDocumentMapper;

    public void syncAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();
        List<VacancyDocument> documents = vacancies.stream()
                .map(vacancyDocumentMapper::vacancyToDocument)
                .toList();
        vacancySearchRepository.saveAll(documents);
    }

    public void syncVacancy(Vacancy vacancy) {
        VacancyDocument document = vacancyDocumentMapper.vacancyToDocument(vacancy);
        vacancySearchRepository.save(document);
    }

    public void deleteFromIndex(Integer vacancyId) {
        vacancySearchRepository.deleteById(vacancyId);
    }
//Генна на
}
