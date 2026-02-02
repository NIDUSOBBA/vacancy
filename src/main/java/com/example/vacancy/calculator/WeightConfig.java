package com.example.vacancy.calculator;

import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

@Builder
@Value
public class WeightConfig {
    int experienceWeightPerYear;
    int maxExperienceYears;
    long salaryStepAmount;
    int defaultCityWeight;
    List<TopCity> topCities;
    List<TopCompany> topCompanies;

    public static WeightConfig defaultConfig() {
        return WeightConfig.builder()
                .experienceWeightPerYear(10)
                .maxExperienceYears(6)
                .salaryStepAmount(10_000)
                .defaultCityWeight(5)
                .topCities(Arrays.asList(
                        new TopCity("москва", 50),
                        new TopCity("санкт-Петербург", 40),
                        new TopCity("новосибирск", 30),
                        new TopCity("екатеринбург", 20),
                        new TopCity("казань", 10)
                ))
                .topCompanies(Arrays.asList(
                        new TopCompany("яндекс", 40),
                        new TopCompany("сбер", 35),
                        new TopCompany("тинькофф", 30),
                        new TopCompany("vk", 25),
                        new TopCompany("ozon", 20)
                ))
                .build();
    }

}