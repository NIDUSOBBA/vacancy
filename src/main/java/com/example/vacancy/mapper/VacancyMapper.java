package com.example.vacancy.mapper;

import com.example.vacancy.dto.DeleteVacancyDto;
import com.example.vacancy.dto.VacancyDto;
import com.example.vacancy.entity.Vacancy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacancyMapper {

    public VacancyDto vacancyToDto(Vacancy vacancy) {
        return new VacancyDto(
                vacancy.getNameVacancy(),
                vacancy.getFieldActivity(),
                vacancy.getDescription());
    }
    public DeleteVacancyDto vacancyToDeleteDto(Vacancy vacancy) {
        return new DeleteVacancyDto(
                "В путь",
                vacancy.getId(),
                vacancy.getNameVacancy(),
                vacancy.getFieldActivity(),
                vacancy.getDescription());
    }

    public Vacancy vacancyDtoToEntity(VacancyDto vacancyDto) {
        return new Vacancy(
                vacancyDto.nameVacancy(),
                vacancyDto.fieldActivity(),
                vacancyDto.description());
    }

    public List<VacancyDto> vacancyToDto(List<Vacancy> vacancies) {
        List<VacancyDto> vacancyDto = new ArrayList<>();
        for (Vacancy vacancy : vacancies) {
            vacancyDto.add(vacancyToDto(vacancy));
        }
        return vacancyDto;
    }
//Генна на
}
