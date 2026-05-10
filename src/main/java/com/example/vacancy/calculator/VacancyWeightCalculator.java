package com.example.vacancy.calculator;

import com.example.vacancy.entity.Vacancy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@Component
public class VacancyWeightCalculator {

    private final WeightConfig config;

    public VacancyWeightCalculator() {
        this.config = WeightConfig.defaultConfig();
    }

    public VacancyWeightCalculator(WeightConfig config) {
        this.config = Objects.requireNonNull(config, "config must not be null");
    }

    public WeightCalculationResult calculateWeight(Vacancy vacancy) {
        int experienceWeight = calculateExperienceWeight(vacancy.getWorkExperience());
        int titleWeight = calculateNameWeight(vacancy.getNameVacancy());
        int salaryWeight = calculateSalaryWeight(vacancy.getSalary());
        int locationWeight = calculateLocationWeight(vacancy.getLocation());
        int companyWeight = calculateCompanyWeight(vacancy.getCompany());

        int totalWeight = experienceWeight + titleWeight + salaryWeight
                + locationWeight + companyWeight;

        return WeightCalculationResult.builder()
                .totalWeight(totalWeight)
                .experienceWeight(experienceWeight)
                .titleWeight(titleWeight)
                .salaryWeight(salaryWeight)
                .locationWeight(locationWeight)
                .companyWeight(companyWeight)
                .build();
    }

    private int calculateExperienceWeight(String yearsString) {
        if (yearsString.matches("\\D+")) {
            return 0;
        }
        int years = Integer.parseInt(yearsString.replaceAll("\\D+", ""));
        int cappedYears = Math.min(years, config.getMaxExperienceYears());
        return cappedYears * config.getExperienceWeightPerYear();
    }

    private int calculateNameWeight(String title) {
        String normalizedTitle = normalizeText(title);
        return Arrays.stream(TitleCategory.values())
                .filter(category -> containsWord(normalizedTitle, category.getKeyword()))
                .mapToInt(TitleCategory::getWeight)
                .findFirst()
                .orElse(0);
    }

    private int calculateSalaryWeight(Integer salary) {
        return (int) (salary / config.getSalaryStepAmount());
    }

    private int calculateLocationWeight(String location) {
        String normalizedLocation = normalizeText(location);
        return config.getTopCities().stream()
                .filter(city -> containsWord(normalizedLocation, city.name()))
                .mapToInt(TopCity::weight)
                .findFirst()
                .orElse(config.getDefaultCityWeight());
    }

    private int calculateCompanyWeight(String company) {
        String normalizedCompany = normalizeText(company);
        return config.getTopCompanies().stream()
                .filter(comp -> containsWord(normalizedCompany, comp.name()))
                .mapToInt(TopCompany::weight)
                .findFirst()
                .orElse(0);
    }

    private String normalizeText(String text) {
        return text.toLowerCase(Locale.ROOT);
    }

    private boolean containsWord(String text, String keyword) {
        String lowerCase = keyword.toLowerCase(Locale.ROOT);
        return text.contains(lowerCase);
    }


}
