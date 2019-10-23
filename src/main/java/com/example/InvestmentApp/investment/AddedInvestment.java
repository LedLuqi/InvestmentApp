package com.example.InvestmentApp.investment;

public class AddedInvestment {
    private Long id;
    private String name;
    private Double interest;
    private Long duration;

    public AddedInvestment(Long id, String name, Double interest, Long duration) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.duration = duration;
    }
}
