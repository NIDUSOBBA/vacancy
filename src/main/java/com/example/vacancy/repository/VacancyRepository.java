package com.example.vacancy.repository;

import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.exception.VacancyNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyRepository {

    private final VacancyCrudRepository vacancyCrudRepository;

    public Vacancy save(Vacancy vacancy) {
        return vacancyCrudRepository.save(vacancy);
    }

    public List<Vacancy> findAll() {
        return vacancyCrudRepository.findAll();
    }

    public Vacancy findById(Integer id) {
        return vacancyCrudRepository.findById(id).orElseThrow(() -> new VacancyNotFound(id));
    }

    public Vacancy update(Vacancy vacancy) {
        return vacancyCrudRepository.save(vacancy);
    }

    public void delete(Vacancy vacancy) {
        vacancyCrudRepository.delete(vacancy);
    }

}
