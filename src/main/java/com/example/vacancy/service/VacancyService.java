package com.example.vacancy.service;

import com.example.vacancy.calculator.WeightCalculationResult;
import com.example.vacancy.dto.*;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.exception.VacancyNotFound;
import com.example.vacancy.mapper.VacancyMapper;
import com.example.vacancy.repository.VacancyRepository;
import com.example.vacancy.calculator.VacancyWeightCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VacancyService {

    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;
    private final VacancyWeightCalculator vacancyWeightCalculator;

    public VacancyDto create(VacancyDto vacancyDto) {
        Vacancy vacancy = vacancyMapper.vacancyDtoToEntity(vacancyDto);
        WeightCalculationResult weightCalculationResult = vacancyWeightCalculator.calculateWeight(vacancy);
        vacancy.setWeight(weightCalculationResult.getTotalWeight());
        Vacancy save = vacancyRepository.save(vacancy);
        return vacancyMapper.vacancyToDto(save);
    }

    public List<VacancyDto> getAll(VacancyPageDto pageDto) {
        String lowerCase = pageDto.sort().toLowerCase();
        Pageable weight;
        if (lowerCase.equals("asc")) {
            weight = PageRequest.of(pageDto.page(), pageDto.size(), Sort.by("weight").ascending());
        } else {
            weight = PageRequest.of(pageDto.page(), pageDto.size(), Sort.by("weight").descending());
        }
        return vacancyMapper.vacancyToDto(vacancyRepository.findAll(weight));
    }

    public VacancyDto getById(Long id) {
        return vacancyMapper.vacancyToDto(vacancyRepository.findById(id).orElseThrow(() -> new VacancyNotFound(id)));
    }

    public VacancyDto updateById(UpdateVacancyDto updateVacancyDto) {
        Vacancy byId = vacancyRepository.findById(updateVacancyDto.id()).orElseThrow(() -> new VacancyNotFound(updateVacancyDto.id()));
        Vacancy updatedVacancy = vacancyMapper.updateDtoToVacancy(byId, updateVacancyDto);
        return vacancyMapper.vacancyToDto(vacancyRepository.save(updatedVacancy));
    }

    public DeleteVacancyDto deleteById(Long id) {
        vacancyRepository.deleteById(id);
        return vacancyMapper.vacancyToDeleteDto(id);
    }

}
