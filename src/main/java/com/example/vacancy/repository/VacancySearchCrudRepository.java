package com.example.vacancy.repository;

import com.example.vacancy.entity.VacancyDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancySearchCrudRepository extends ElasticsearchRepository<VacancyDocument,Integer> {

    List<VacancyDocument> findAllByOrderByWeightDesc();

    List<VacancyDocument> findAllByOrderByWeightAsc();
//Генна на
}
