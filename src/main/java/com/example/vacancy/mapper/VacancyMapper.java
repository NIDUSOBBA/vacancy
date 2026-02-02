package com.example.vacancy.mapper;

import com.example.vacancy.dto.DeleteVacancyDto;
import com.example.vacancy.dto.UpdateVacancyDto;
import com.example.vacancy.dto.VacancyDto;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.util.Status;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacancyMapper {

    public VacancyDto vacancyToDto(Vacancy vacancy) {
        return VacancyDto.builder()
                .name(vacancy.getNameVacancy())
                .description(vacancy.getDescription())
                .company(vacancy.getCompany())
                .location(vacancy.getLocation())
                .salary(vacancy.getSalary())
                .workExperience(vacancy.getWorkExperience())
                .build();
    }

    public DeleteVacancyDto vacancyToDeleteDto(Long id) {
        return DeleteVacancyDto.builder()
                .status(Status.LIQUIDATED)
                .id(id)
                .build();
    }

    public Vacancy vacancyDtoToEntity(VacancyDto vacancyDto) {
        return Vacancy.builder()
                .nameVacancy(vacancyDto.name())
                .description(vacancyDto.description())
                .company(vacancyDto.company())
                .location(vacancyDto.location())
                .salary(vacancyDto.salary())
                .workExperience(vacancyDto.workExperience())
                .build();
    }

    public List<VacancyDto> vacancyToDto(Page<Vacancy> vacancies) {
        return vacancies.map(this::vacancyToDto).stream().toList();
    }

    public Vacancy updateDtoToVacancy(Vacancy byId, UpdateVacancyDto updateVacancyDto) {
        byId.setNameVacancy(updateVacancyDto.name());
        byId.setDescription(updateVacancyDto.description());
        byId.setSalary(updateVacancyDto.salary());
        return byId;
    }
}
