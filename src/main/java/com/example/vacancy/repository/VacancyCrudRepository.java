package com.example.vacancy.repository;

import com.example.vacancy.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyCrudRepository extends JpaRepository<Vacancy, Integer> {

}
