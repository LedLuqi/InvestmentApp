package com.example.InvestmentApp.investment;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Investment {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double interest;
    @Enumerated(EnumType.STRING)
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
