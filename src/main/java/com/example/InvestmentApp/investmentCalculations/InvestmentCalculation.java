package com.example.InvestmentApp.investmentCalculations;

import com.example.InvestmentApp.investment.Investment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class InvestmentCalculation {

    @Id
    @GeneratedValue
    private Long id;
    private Long amount;
    private LocalDate caluclationDate;
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
}
