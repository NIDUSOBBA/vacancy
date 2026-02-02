package com.example.vacancy.controller;

import com.example.vacancy.dto.*;
import com.example.vacancy.service.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vacancy")
@RequiredArgsConstructor
@Validated
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public VacancyDto create(@Valid @RequestBody VacancyDto vacancyDto) {
        return vacancyService.create(vacancyDto);
    }

    @GetMapping
    public List<VacancyDto> getAll(@RequestBody VacancyPageDto pageDto) {
        return vacancyService.getAll(pageDto);
    }

    @GetMapping("/{id}")
    public VacancyDto getById(@PathVariable Long id) {
        return vacancyService.getById(id);
    }

    @PatchMapping
    public VacancyDto updateById(@RequestBody UpdateVacancyDto updateVacancyDto) {
        return vacancyService.updateById(updateVacancyDto);
    }

    @DeleteMapping("/{id}")
    public DeleteVacancyDto deleteById(@PathVariable Long id) {
        return vacancyService.deleteById(id);
    }

}
