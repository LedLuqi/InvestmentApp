package com.example.InvestmentApp.investmentCalculations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/investments/")
public class InvestmentCaluclationController {

    InvestmentsCalculationService calculationService;

    @Autowired
    public InvestmentCaluclationController(InvestmentsCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.OK)
    public  InvestmentCalculationInfo getInvestmentAndHistoryOfCalculation (@PathParam("id") Long id) {
        return calculationService.getInfoAndHistoryCalculations(id);
    }

    @PostMapping("{id}/calculations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AddedInvestmentCalculation caluclate(@RequestBody InvestmentCalculationDTO investmentCalculationDTO, @PathParam("id") Long id) throws FutureInvestmentCalculationException {
       return calculationService.saveInvestmentCalculation(calculationService.getAddedInvestmentCalculation(investmentCalculationDTO,id));
    }

    @ExceptionHandler({ FutureInvestmentCalculationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleFutureInvestmentCalculationException() {
    }

}
