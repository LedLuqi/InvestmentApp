package com.example.InvestmentApp.investmentCalculations;

import com.example.InvestmentApp.investment.CapitalizationPeriod;

import java.time.LocalDate;
import java.util.List;

public class InvestmentCalculationInfo {

    private String intereName;
    private Long interestInterest;
    private CapitalizationPeriod capitalization;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private List<InvestmentCalculation> calculationList;

    public InvestmentCalculationInfo(String intereName, Long interestInterest, CapitalizationPeriod capitalization,
                                     LocalDate dateOfStart, LocalDate dateOfEnd, List<InvestmentCalculation> calculationList) {
        this.intereName = intereName;
        this.interestInterest = interestInterest;
        this.capitalization = capitalization;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.calculationList = calculationList;
    }
}
