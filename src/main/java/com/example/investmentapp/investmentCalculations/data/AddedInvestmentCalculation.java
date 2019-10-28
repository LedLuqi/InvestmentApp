package com.example.investmentapp.investmentCalculations.data;

import com.example.investmentapp.investment.data.Investment;

import java.time.LocalDate;

public class AddedInvestmentCalculation {

    private Long amount;
    private LocalDate calculateDate;
    private Investment investment;
    private AlgorithmType algorithm;
    private Long profit;

    public AddedInvestmentCalculation(Long amount, LocalDate calculateDate, Investment investment, AlgorithmType algorithm, Long profit) {
        this.amount = amount;
        this.calculateDate = calculateDate;
        this.investment = investment;
        this.algorithm = algorithm;
        this.profit = profit;
    }

    public Long getAmount() {
        return amount;
    }

    public LocalDate getCalculateDate() {
        return calculateDate;
    }

    public Investment getInvestment() {
        return investment;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public Long getProfit() {
        return profit;
    }
}
