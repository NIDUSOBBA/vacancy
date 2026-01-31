package com.example.vacancy.service;

import com.example.vacancy.dto.DeleteVacancyDto;
import com.example.vacancy.dto.UpdateVacancyDto;
import com.example.vacancy.dto.VacancyDto;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.event.VacancyCreatedEvent;
import com.example.vacancy.event.VacancyDeletedEvent;
import com.example.vacancy.event.VacancyEventListener;
import com.example.vacancy.event.VacancyUpdatedEvent;
import com.example.vacancy.mapper.VacancyMapper;
import com.example.vacancy.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional
public class VacancyService {

    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;
    private final VacancyEventListener  vacancyEventListener;

    public VacancyDto createVacancy(VacancyDto vacancyDto) {
        Vacancy save = vacancyRepository.save(fieldSearch(vacancyDto));
        vacancyEventListener.handleVacancyCreated(new VacancyCreatedEvent(save));
        return vacancyMapper.vacancyToDto(save);
    }

    public List<VacancyDto> getAllVacancies() {
        return vacancyMapper.vacancyToDto(
                vacancyRepository.findAll()
        );
    }

    public VacancyDto getVacanciesById(Integer id) {
        return vacancyMapper.vacancyToDto(
                vacancyRepository.findById(id
                )
        );
    }

    public VacancyDto updateVacancyById(UpdateVacancyDto updateVacancyDto) {
        Vacancy byId = vacancyRepository.findById(updateVacancyDto.id());
        byId.setNameVacancy(updateVacancyDto.nameVacancy());
        byId.setFieldActivity(updateVacancyDto.fieldActivity());
        byId.setDescription(updateVacancyDto.description());
        vacancyEventListener.handleVacancyUpdated(new VacancyUpdatedEvent(byId));
        return vacancyMapper.vacancyToDto(
                vacancyRepository.update(byId)
        );
    }

    public DeleteVacancyDto deleteVacancyById(Integer id) {
        Vacancy byId = vacancyRepository.findById(id);
        vacancyRepository.delete(byId);
        vacancyEventListener.handleVacancyDeleted(new VacancyDeletedEvent(byId.getId()));
        return vacancyMapper.vacancyToDeleteDto(byId);
    }

    public Vacancy fieldSearch(VacancyDto vacancyDto) {
        Vacancy vacancy = vacancyMapper.vacancyDtoToEntity(vacancyDto);
        int field = vacancy.getWeight();
        String fieldActivity = vacancy.getFieldActivity().toLowerCase();
        switch (fieldActivity) {
            case "муницип" -> field += 10;
            case "гос" -> field += 20;
            case "мед" -> field += 30;
        }
        vacancy.setWeight(field);
        return vacancy;
    }
    //Генна на
}
