package com.example.investmentapp.investmentCalculations.data;

public class InvestmentCalculationDTO {
    private Long amount;
    private AlgorithmType algorithm;

    public InvestmentCalculationDTO(AlgorithmType algorithm, Long amount) {
        this.amount = amount;
        this.algorithm = algorithm;
    }

    public InvestmentCalculationDTO() {
    }

    public Long getAmount() {
        return amount;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }
}
