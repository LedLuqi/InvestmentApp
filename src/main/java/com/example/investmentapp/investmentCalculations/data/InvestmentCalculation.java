package com.example.investmentapp.investmentCalculations.data;

import com.example.investmentapp.investment.data.Investment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class InvestmentCalculation {

    @Id
    @GeneratedValue
    private Long id;
    private Long amount;
    private LocalDate caluclationDate;
    @ManyToOne
    @JoinColumn(name = "DETAILS_ID")
    private Investment investment;
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithm;
    private Long profit;

    public InvestmentCalculation(Long amount, LocalDate caluclationDate, Investment investment, AlgorithmType algorithm, Long profit) {
        this.amount = amount;
        this.caluclationDate = caluclationDate;
        this.investment = investment;
        this.algorithm = algorithm;
        this.profit = profit;
    }
    public InvestmentCalculation(Long id, Long amount, LocalDate caluclationDate, Investment investment, AlgorithmType algorithm, Long profit) {
        this.id = id;
        this.amount = amount;
        this.caluclationDate = caluclationDate;
        this.investment = investment;
        this.algorithm = algorithm;
        this.profit = profit;
    }

    public InvestmentCalculation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getCaluclationDate() {
        return caluclationDate;
    }

    public void setCaluclationDate(LocalDate caluclationDate) {
        this.caluclationDate = caluclationDate;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }
}
