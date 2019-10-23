package com.example.InvestmentApp.investment;

import java.time.LocalDate;

public class InvestmentDTO {

    private String name;
    private Double interest;
    private CapitalizationPeriod capitalization;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public String getName() {
        return name;
    }

    public Double getInterest() {
        return interest;
    }

    public CapitalizationPeriod getCapitalization() {
        return capitalization;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }
}
