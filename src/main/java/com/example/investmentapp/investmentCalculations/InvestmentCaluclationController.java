package com.example.investmentapp.investmentCalculations;

import com.example.investmentapp.investmentCalculations.data.AddedInvestmentCalculation;
import com.example.investmentapp.investmentCalculations.data.InvestmentCalculationDTO;
import com.example.investmentapp.investmentCalculations.data.InvestmentCalculationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investments")
public class InvestmentCaluclationController {

    InvestmentsCalculationService calculationService;

    @Autowired
    public InvestmentCaluclationController(InvestmentsCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/{id}/calculations")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    InvestmentCalculationInfo getInvestmentAndHistoryOfCalculation (@PathVariable("id") Long id) {
        return calculationService.getInfoAndHistoryCalculations(id);
    }

    @PostMapping("/{id}/calculations")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    AddedInvestmentCalculation caluclate(@RequestBody InvestmentCalculationDTO investmentCalculationDTO, @PathVariable("id") Long id) throws FutureInvestmentCalculationException {
        AddedInvestmentCalculation addedInvestmentCalculation = calculationService.getAddedInvestmentCalculation(investmentCalculationDTO,id);
       return calculationService.saveInvestmentCalculation(addedInvestmentCalculation);
    }

    @ExceptionHandler({ FutureInvestmentCalculationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleFutureInvestmentCalculationException() {
    }

}
