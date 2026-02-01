package com.example.vacancy.controller;

import com.example.vacancy.dto.DeleteVacancyDto;
import com.example.vacancy.dto.UpdateVacancyDto;
import com.example.vacancy.dto.VacancyDto;
import com.example.vacancy.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<VacancyDto> createVacancy(@RequestBody VacancyDto vacancyDto) {
        return ResponseEntity.ok().body(vacancyService.createVacancy(vacancyDto));
    }

    @GetMapping
    public ResponseEntity<List<VacancyDto>> getAllVacancies() {
        return ResponseEntity.ok().body(vacancyService.getAllVacancies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyDto> getVacancyById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(vacancyService.getVacanciesById(id));
    }

    @PatchMapping
    public ResponseEntity<VacancyDto> updateVacancyById(@RequestBody UpdateVacancyDto updateVacancyDto) {
        return ResponseEntity.ok().body(vacancyService.updateVacancyById(updateVacancyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteVacancyDto> deleteVacancyById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(vacancyService.deleteVacancyById(id));
    }

}
