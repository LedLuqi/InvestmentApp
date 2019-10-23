package com.example.InvestmentApp.investmentCalculations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentCalculationRepository extends JpaRepository<InvestmentCalculation, Long> {
}
