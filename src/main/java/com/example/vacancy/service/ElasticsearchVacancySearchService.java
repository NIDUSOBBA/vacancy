package com.example.vacancy.service;

import com.example.vacancy.dto.ElasticsearchVacancyPageDto;
import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.mapper.VacancyDocumentMapper;
import com.example.vacancy.repository.ElasticsearchVacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ElasticsearchVacancySearchService {
    private final ElasticsearchVacancyRepository repository;
    private final VacancyDocumentMapper vacancyDocumentMapper;

    public List<VacancyDocumentDto> findAll(ElasticsearchVacancyPageDto pageDto) {
        String lowerCase = pageDto.sort().toLowerCase();
        List<VacancyDocumentDto> vacancyDocumentDto;
        if (lowerCase.equals("asc")) {
            Pageable weight = PageRequest.of(pageDto.page(), pageDto.size(), Sort.by("weight").ascending());
            vacancyDocumentDto = vacancyDocumentMapper.vacancyDocumentToDto(repository.findAll(weight));
        } else {
            Pageable weight = PageRequest.of(pageDto.page(), pageDto.size(), Sort.by("weight").descending());
            vacancyDocumentDto = vacancyDocumentMapper.vacancyDocumentToDto(repository.findAll(weight));
        }
        return vacancyDocumentDto;
    }


}
