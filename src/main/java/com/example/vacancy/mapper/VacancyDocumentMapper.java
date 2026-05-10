package com.example.vacancy.mapper;

import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.entity.VacancyDocument;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacancyDocumentMapper {

    public VacancyDocument vacancyToDocument(Vacancy vacancy) {
        return VacancyDocument.builder()
                .id(vacancy.getId())
                .nameVacancy(vacancy.getNameVacancy())
                .description(vacancy.getDescription())
                .company(vacancy.getCompany())
                .location(vacancy.getLocation())
                .salary(vacancy.getSalary())
                .workExperience(vacancy.getWorkExperience())
                .weight(vacancy.getWeight())
                .build();
    }

    public VacancyDocumentDto vacancyToDto(VacancyDocument vacancyDocument) {
        return VacancyDocumentDto.builder()
                .name(vacancyDocument.getNameVacancy())
                .description(vacancyDocument.getDescription())
                .company(vacancyDocument.getCompany())
                .location(vacancyDocument.getLocation())
                .salary(vacancyDocument.getSalary())
                .workExperience(vacancyDocument.getWorkExperience())
                .weight(vacancyDocument.getWeight())
                .build();
    }

    public List<VacancyDocumentDto> vacancyDocumentToDto(Page<VacancyDocument> vacanciesDocuments) {
        return vacanciesDocuments.map(this::vacancyToDto).stream().toList();
    }

}
