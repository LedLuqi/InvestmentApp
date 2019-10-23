package com.example.InvestmentApp.investment;

import java.time.LocalDate;

public class Investment {
    private Long id;
    private String name;
    private Double interest;
    private CapitalizationPeriod capitalization;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public Investment(String name, Double interest, CapitalizationPeriod capitalization, LocalDate dateOfStart, LocalDate dateOfEnd) {
        this.name = name;
        this.interest = interest;
        this.capitalization = capitalization;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getInterest() {
        return interest;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public CapitalizationPeriod getCapitalization() {
        return capitalization;
    }
}
