package com.example.vacancy.controller;

import com.example.vacancy.dto.ElasticsearchVacancyPageDto;
import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.service.ElasticsearchVacancySearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vacancies/search")
@RequiredArgsConstructor
@Validated
public class VacancySearchController {
    private final ElasticsearchVacancySearchService elasticsearchVacancySearchService;

    @GetMapping
    public List<VacancyDocumentDto> findAll(@Valid @RequestBody ElasticsearchVacancyPageDto pageDto) {
        return elasticsearchVacancySearchService.findAll(pageDto);
    }

}
