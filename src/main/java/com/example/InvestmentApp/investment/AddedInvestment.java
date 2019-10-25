package com.example.InvestmentApp.investment;

import org.springframework.stereotype.Component;

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

    public AddedInvestment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
