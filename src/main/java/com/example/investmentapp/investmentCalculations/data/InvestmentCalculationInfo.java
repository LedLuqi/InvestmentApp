package com.example.investmentapp.investmentCalculations.data;

import com.example.investmentapp.investment.data.CapitalizationPeriod;

import java.time.LocalDate;
import java.util.List;

public class InvestmentCalculationInfo {

    private String intereName;
    private Long interestInterest;
    private CapitalizationPeriod capitalization;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private List<InvestmentCalculation> calculationList;

    public InvestmentCalculationInfo(String interestName, Long interestInterest, CapitalizationPeriod capitalization,
                                     LocalDate dateOfStart, LocalDate dateOfEnd, List<InvestmentCalculation> calculationList) {
        this.intereName = interestName;
        this.interestInterest = interestInterest;
        this.capitalization = capitalization;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.calculationList = calculationList;
    }

    public InvestmentCalculationInfo() {
    }

    public String getInterestName() {
        return intereName;
    }

    public void setInterestName(String interestName) {
        this.intereName = intereName;
    }

    public Long getInterestInterest() {
        return interestInterest;
    }

    public void setInterestInterest(Long interestInterest) {
        this.interestInterest = interestInterest;
    }

    public CapitalizationPeriod getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(CapitalizationPeriod capitalization) {
        this.capitalization = capitalization;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public List<InvestmentCalculation> getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(List<InvestmentCalculation> calculationList) {
        this.calculationList = calculationList;
    }
}
