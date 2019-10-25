package com.example.InvestmentApp.investmentCalculations;

import java.time.LocalDate;

public class InvestmentCalculationDTO {
    private Long amount;
    private AlgorithmType algorithm;

    public InvestmentCalculationDTO(Long amount, LocalDate calculateDate, Long investmentId, AlgorithmType algorithm, Long profit) {
        this.amount = amount;
        this.algorithm = algorithm;
    }

    public Long getAmount() {
        return amount;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

}
