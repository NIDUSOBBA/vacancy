package com.example.vacancy.mapper;

import com.example.vacancy.dto.VacancyDocumentDto;
import com.example.vacancy.entity.Vacancy;
import com.example.vacancy.entity.VacancyDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacancyDocumentMapper {

    public VacancyDocument vacancyToDocument(Vacancy vacancy) {
        return new VacancyDocument(
                vacancy.getId(),
                vacancy.getNameVacancy(),
                vacancy.getFieldActivity(),
                vacancy.getDescription(),
                vacancy.getWeight()
        );
    }

    public VacancyDocumentDto vacancyToDto(VacancyDocument vacancyDocument) {
        return new VacancyDocumentDto(
                vacancyDocument.getNameVacancy(),
                vacancyDocument.getFieldActivity(),
                vacancyDocument.getDescription(),
                vacancyDocument.getWeight()
        );
    }

    public List<VacancyDocumentDto> vacancyDocumentToDto(List<VacancyDocument> vacanciesDocuments) {
        List<VacancyDocumentDto> vacancyDocumentDto = new ArrayList<>();
        for (VacancyDocument vacancyDocument : vacanciesDocuments) {
            vacancyDocumentDto.add(vacancyToDto(vacancyDocument));
        }
        return vacancyDocumentDto;
    }
}
