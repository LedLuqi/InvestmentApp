package com.example.InvestmentApp.investmentCalculations;

import com.example.InvestmentApp.investment.CapitalizationPeriod;
import com.example.InvestmentApp.investment.Investment;
import com.example.InvestmentApp.investment.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Component
public class InvestmentsCalculationService {

    private InvestmentCalculationRepository repository;

    private InvestmentService investmentService;

    @Autowired
    public InvestmentsCalculationService(InvestmentCalculationRepository repository, InvestmentService investmentService) {
        this.repository = repository;
        this.investmentService = investmentService;
    }

    InvestmentCalculationInfo getInfoAndHistoryCalculations(Long id){
        Investment investment = investmentService.getInvestmentById(id);
        return new InvestmentCalculationInfo(investment.getName(),investment.getId(),investment.getCapitalization(),
                investment.getDateOfStart(),investment.getDateOfEnd(),repository.findAll());
    }

    Integer getValidation (CapitalizationPeriod capitalizationPeriod) {
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

    Double calculationInterestForCalculationDay (InvestmentCalculationDTO investmentCalculationDTO){

        Investment investment = investmentService.getInvestmentById(investmentCalculationDTO.getInvestmentId());

        Long days = ChronoUnit.DAYS.between(investment.getDateOfStart(), investmentCalculationDTO.getCalculateDate());

        Long quantityOfValidation = (days / 360) * getValidation(investment.getCapitalization());

        return (((Math.pow((1 + (1 * (investment.getInterest() / quantityOfValidation)) / 100), quantityOfValidation)) - 1) * 100);

    }

    Double calculationInterestForEndOfInterest (InvestmentCalculationDTO investmentCalculationDTO){

        Investment investment = investmentService.getInvestmentById(investmentCalculationDTO.getInvestmentId());

        Long days = ChronoUnit.DAYS.between(investment.getDateOfStart(), investment.getDateOfEnd());

        Long quantityOfValidation = (days / 360) * getValidation(investment.getCapitalization());

        return (((Math.pow((1 + (1 * (investment.getInterest() / quantityOfValidation)) / 100), quantityOfValidation)) - 1) * 100);

    }

    Double calculationTrigger (InvestmentCalculationDTO investmentCalculationDTO) {

        switch (investmentCalculationDTO.getAlgorithm()){
            case ALGORITHM_FOR_CALCULATION_DAY:
                return calculationInterestForCalculationDay(investmentCalculationDTO);
            case ALGORITHM_FOR_END_OF_INTEREST:
                return calculationInterestForEndOfInterest(investmentCalculationDTO);
        }
        throw new NullPointerException();
    }

    AddedInvestmentCalculation saveInvestmentCalculation (AddedInvestmentCalculation addedInvestment){
        repository.save( new InvestmentCalculation(addedInvestment.getAmount(),addedInvestment.getCalculateDate(),
                addedInvestment.getInvestment(),addedInvestment.getAlgorithm(),addedInvestment.getProfit()));
        return addedInvestment;
    }

    public Long calculateProfit(InvestmentCalculationDTO investmentCalculationDTO) {
        BigDecimal investment = new BigDecimal((calculationTrigger(investmentCalculationDTO) / 100));
        BigDecimal amount = new BigDecimal(investmentCalculationDTO.getAmount());
        return investment.multiply(amount).longValue();
    }

    AddedInvestmentCalculation getAddedInvermentCalculation (InvestmentCalculationDTO investmentCalculationDTO, Long id){
        return new AddedInvestmentCalculation(investmentCalculationDTO.getAmount(),
                investmentCalculationDTO.getCalculateDate(),investmentService.getInvestmentById(id),
                investmentCalculationDTO.getAlgorithm(),calculateProfit(investmentCalculationDTO));
    }


}
