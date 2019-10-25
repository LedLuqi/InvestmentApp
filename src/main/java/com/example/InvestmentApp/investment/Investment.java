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

    public Investment() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public void setCapitalization(CapitalizationPeriod capitalization) {
        this.capitalization = capitalization;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interest=" + interest +
                ", capitalization=" + capitalization +
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                '}';
    }
}
