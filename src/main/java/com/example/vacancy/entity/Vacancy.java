package com.example.vacancy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Field(type = FieldType.Text)
    private String nameVacancy;

    @Field(type = FieldType.Text)
    private String fieldActivity;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Integer)
    private Integer weight = 100;

    public Vacancy(String nameVacancy, String fieldActivity, String description) {
        this.nameVacancy = nameVacancy;
        this.fieldActivity = fieldActivity;
        this.description = description;
    }
}
