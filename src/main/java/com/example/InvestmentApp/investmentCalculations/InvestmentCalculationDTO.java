package com.example.InvestmentApp.investmentCalculations;

import java.time.LocalDate;

public class InvestmentCalculationDTO {
    private Long amount;
    private LocalDate calculateDate;
    private Long investmentId;
    private AlgorithmType algorithm;
    private Long profit;

    public InvestmentCalculationDTO(Long amount, LocalDate calculateDate, Long investmentId, AlgorithmType algorithm, Long profit) {
        this.amount = amount;
        this.calculateDate = calculateDate;
        this.investmentId = investmentId;
        this.algorithm = algorithm;
        this.profit = profit;
    }

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
