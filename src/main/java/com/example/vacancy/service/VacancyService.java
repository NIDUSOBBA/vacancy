package com.example.vacancy.service;

import com.example.vacancy.calculator.WeightCalculationResult;
import com.example.vacancy.dto.*;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.event.VacancyCreatedEvent;
import com.example.vacancy.event.VacancyDeletedEvent;
import com.example.vacancy.event.VacancyUpdatedEvent;
import com.example.vacancy.exception.VacancyNotFound;
import com.example.vacancy.mapper.VacancyMapper;
import com.example.vacancy.repository.VacancyRepository;
import com.example.vacancy.calculator.VacancyWeightCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VacancyService {

    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final VacancyWeightCalculator vacancyWeightCalculator;

    public VacancyDto create(VacancyDto vacancyDto) {
        Vacancy vacancy = vacancyMapper.vacancyDtoToEntity(vacancyDto);
        WeightCalculationResult weightCalculationResult = vacancyWeightCalculator.calculateWeight(vacancy);
        vacancy.setWeight(weightCalculationResult.getTotalWeight());
        Vacancy save = vacancyRepository.save(vacancy);
        applicationEventPublisher.publishEvent(new VacancyCreatedEvent(save));
        return vacancyMapper.vacancyToDto(save);
    }

    public List<VacancyDto> getAll(VacancyPageDto pageDto) {
        return vacancyMapper.vacancyToDto(vacancyRepository.findAll(PageRequest.of(pageDto.page(), pageDto.size())));
    }

    public VacancyDto getById(Long id) {
        return vacancyMapper.vacancyToDto(vacancyRepository.findById(id).orElseThrow(() -> new VacancyNotFound(id)));
    }

    public VacancyDto updateById(UpdateVacancyDto updateVacancyDto) {
        Vacancy byId = vacancyRepository.findById(updateVacancyDto.id()).orElseThrow(() -> new VacancyNotFound(updateVacancyDto.id()));
        Vacancy updatedVacancy = vacancyMapper.updateDtoToVacancy(byId, updateVacancyDto);
        applicationEventPublisher.publishEvent(new VacancyUpdatedEvent(updatedVacancy));
        return vacancyMapper.vacancyToDto(vacancyRepository.save(updatedVacancy));
    }

    public DeleteVacancyDto deleteById(Long id) {
        vacancyRepository.deleteById(id);
        applicationEventPublisher.publishEvent(new VacancyDeletedEvent(id));
        return vacancyMapper.vacancyToDeleteDto(id);
    }

}
