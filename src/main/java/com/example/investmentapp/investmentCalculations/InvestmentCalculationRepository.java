package com.example.investmentapp.investmentCalculations;

import com.example.investmentapp.investmentCalculations.data.InvestmentCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentCalculationRepository extends JpaRepository<InvestmentCalculation, Long> {
}
