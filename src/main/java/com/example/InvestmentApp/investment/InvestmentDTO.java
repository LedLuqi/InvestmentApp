package com.example.InvestmentApp.investment;

import java.time.LocalDate;

public class InvestmentDTO {

    private String name;
    private Double interest;
    private CapitalizationPeriod capitalizationPeriod;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public InvestmentDTO() {
    }

    public String getName() {
        return name;
    }

    public Double getInterest() {
        return interest;
    }

    public CapitalizationPeriod getCapitalization() {
        return capitalizationPeriod;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public CapitalizationPeriod getCapitalizationPeriod() {
        return capitalizationPeriod;
    }

    public void setCapitalizationPeriod(CapitalizationPeriod capitalizationPeriod) {
        this.capitalizationPeriod = capitalizationPeriod;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}
