package com.example.vacancy.repository;

import com.example.vacancy.entity.VacancyDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticsearchVacancyRepository extends ElasticsearchRepository<VacancyDocument,Long> {

    Page<VacancyDocument> findAll(Pageable sort);

}
