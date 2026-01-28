package com.example.vacancy.controller;

import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.service.VacancySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancies/search")
@RequiredArgsConstructor
public class VacancySearchController {
    private final VacancySearchService vacancySearchService;

    @GetMapping("/asc")
    public ResponseEntity<List<VacancyDocumentDto>> findAllAsc() {
        return ResponseEntity.ok().body(vacancySearchService.findAllAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<VacancyDocumentDto>> findAllDesc() {
        return ResponseEntity.ok().body(vacancySearchService.findAllDesc());
    }
}
