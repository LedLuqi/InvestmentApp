package com.example.InvestmentApp.investmentCalculations;

import java.time.LocalDate;

public class InvestmentCalculationDTO {
    private Long amount;
    private LocalDate calculateDate;
    private Long investmentId;
    private AlgorithmType algorithm;
    private Long profit;

    public Long getAmount() {
        return amount;
    }

    public LocalDate getCalculateDate() {
        return calculateDate;
    }

    public Long getInvestmentId() {
        return investmentId;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public Long getProfit() {
        return profit;
    }
}
