package com.example.vacancy.repository;

import com.example.vacancy.entity.VacancyDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancySearchRepository {
    private final VacancySearchCrudRepository vacancySearchCrudRepository;

    public void save(VacancyDocument document) {
        vacancySearchCrudRepository.save(document);
    }

    public void saveAll(List<VacancyDocument> vacancyDocuments) {
        vacancySearchCrudRepository.saveAll(vacancyDocuments);
    }

    public List<VacancyDocument> findAllByOrderByWeightDesc() {
        return vacancySearchCrudRepository.findAllByOrderByWeightDesc();
    }

    public List<VacancyDocument> findAllByOrderByWeightAsc() {
        return vacancySearchCrudRepository.findAllByOrderByWeightAsc();
    }

    public void deleteById(Integer vacancyId) {
        vacancySearchCrudRepository.deleteById(vacancyId);
    }
//Генна на
}
