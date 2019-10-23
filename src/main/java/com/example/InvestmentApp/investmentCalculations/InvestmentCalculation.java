package com.example.InvestmentApp.investmentCalculations;

import com.example.InvestmentApp.investment.Investment;

import java.time.LocalDate;

public class InvestmentCalculation {
    private Long id;
    private Long amount;
    private LocalDate caluclationDate;
    private Investment investment;
    private AlgorithmType algorithm;
    private Long profit;

    public InvestmentCalculation(Long amount, LocalDate caluclationDate, Investment investment, AlgorithmType algorithm, Long profit) {
        this.amount = amount;
        this.caluclationDate = caluclationDate;
        this.investment = investment;
        this.algorithm = algorithm;
        this.profit = profit;
    }
}
