package com.example.vacancy.service;

import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.mapper.VacancyDocumentMapper;
import com.example.vacancy.repository.VacancySearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VacancySearchService {
    private final VacancySearchRepository vacancySearchRepository;
    private final VacancyDocumentMapper vacancyDocumentMapper;

    public List<VacancyDocumentDto> findAllAsc() {
        return vacancyDocumentMapper.vacancyDocumentToDto(
                vacancySearchRepository.findAllByOrderByWeightAsc()
        );
    }

    public List<VacancyDocumentDto> findAllDesc() {
        return vacancyDocumentMapper.vacancyDocumentToDto(
                vacancySearchRepository.findAllByOrderByWeightDesc()
        );
    }

}
