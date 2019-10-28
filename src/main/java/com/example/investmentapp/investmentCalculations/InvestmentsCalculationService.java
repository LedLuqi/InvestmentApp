package com.example.investmentapp.investmentCalculations;

import com.example.investmentapp.investment.data.CapitalizationPeriod;
import com.example.investmentapp.investment.data.Investment;
import com.example.investmentapp.investment.InvestmentService;
import com.example.investmentapp.investmentCalculations.data.AddedInvestmentCalculation;
import com.example.investmentapp.investmentCalculations.data.InvestmentCalculation;
import com.example.investmentapp.investmentCalculations.data.InvestmentCalculationDTO;
import com.example.investmentapp.investmentCalculations.data.InvestmentCalculationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class InvestmentsCalculationService {

    private InvestmentCalculationRepository calculationRepository;

    private InvestmentService investmentService;

    @Autowired
    public InvestmentsCalculationService(InvestmentCalculationRepository calculationRepository, InvestmentService investmentService) {
        this.calculationRepository = calculationRepository;
        this.investmentService = investmentService;
    }

    InvestmentCalculationInfo getInfoAndHistoryCalculations(Long id) {
        Investment investment = investmentService.getInvestmentById(id);
        return new InvestmentCalculationInfo(investment.getName(), investment.getId(), investment.getCapitalization(),
                investment.getDateOfStart(), investment.getDateOfEnd(), calculationRepository.findAll());
    }

    Integer getValidation(CapitalizationPeriod capitalizationPeriod) {
        Integer validation = null;
        switch (capitalizationPeriod) {
            case ONE_MONTH:
                validation = 12;
                break;
            case THREE_MONTH:
                validation = 4;
                break;
            case SIX_MONTH:
                validation = 2;
                break;
            case ELEVEN_MONTH:
                validation = 1;
        }
        return validation;
    }

    Double calculationInterestForDate(Investment investment, LocalDate date) {

        Long days = ChronoUnit.DAYS.between(investment.getDateOfStart(), date);
        Integer validationsPerYear = getValidation(investment.getCapitalization());
        Long quantityOfValidation = (days / 360) * validationsPerYear;

        return Math.pow(1 + ((investment.getInterest() / 100) / validationsPerYear), quantityOfValidation);
    }

    Double calculationTrigger(InvestmentCalculationDTO investmentCalculationDTO, Investment investment, LocalDate date) {

        switch (investmentCalculationDTO.getAlgorithm()) {
            case ALGORITHM_FOR_CALCULATION_DAY:
                return calculationInterestForDate(investment, date);
            case ALGORITHM_FOR_END_OF_INTEREST:
                return calculationInterestForDate(investment, investment.getDateOfEnd());
            default:
                throw new IllegalArgumentException();
        }
    }

    AddedInvestmentCalculation saveInvestmentCalculation(AddedInvestmentCalculation addedInvestment) {
        calculationRepository.save(new InvestmentCalculation(addedInvestment.getAmount(), addedInvestment.getCalculateDate(),
                addedInvestment.getInvestment(), addedInvestment.getAlgorithm(), addedInvestment.getProfit()));
        return addedInvestment;
    }

    public Long calculateProfit(InvestmentCalculationDTO investmentCalculationDTO, Investment investmentEntity, LocalDate date) {
        BigDecimal investment = new BigDecimal((calculationTrigger(investmentCalculationDTO, investmentEntity, date) / 100));
        BigDecimal amount = new BigDecimal(investmentCalculationDTO.getAmount());
        return investment.multiply(amount).longValue();
    }

    AddedInvestmentCalculation getAddedInvestmentCalculation(InvestmentCalculationDTO investmentCalculationDTO, Long id) throws FutureInvestmentCalculationException {

        Investment investment = investmentService.getInvestmentById(id);

        if (investmentService.getInvestmentById(id).getDateOfStart().isAfter(LocalDate.now()))
            throw new FutureInvestmentCalculationException();

        LocalDate date = LocalDate.now();
        Long profit = calculateProfit(investmentCalculationDTO, investment, date);

        return new AddedInvestmentCalculation(investmentCalculationDTO.getAmount(), date,
                investment, investmentCalculationDTO.getAlgorithm(), profit);
    }


}
