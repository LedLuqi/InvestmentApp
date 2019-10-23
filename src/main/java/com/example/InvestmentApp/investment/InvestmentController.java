package com.example.InvestmentApp.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class InvestmentController {

    private InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<InvestmentInfo> getList() {
        return investmentService.getInvestmentInfoList();
    }

    @PostMapping("/investments")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AddedInvestment addInvestment(@RequestBody InvestmentDTO investmentDTO) {
        return investmentService.getAddedInvestment(investmentService.saveInvestment(investmentDTO));
    }
}
