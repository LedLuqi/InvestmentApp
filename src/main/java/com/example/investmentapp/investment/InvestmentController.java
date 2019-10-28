package com.example.investmentapp.investment;

import com.example.investmentapp.investment.data.AddedInvestment;
import com.example.investmentapp.investment.data.InvestmentDTO;
import com.example.investmentapp.investment.data.InvestmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestmentController {

    private InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<InvestmentInfo> getListInfo() {
        return investmentService.getInvestmentInfoList();
    }

    @PostMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    AddedInvestment addInvestmentAndGetView(@RequestBody @Valid InvestmentDTO investmentDTO) {
        return investmentService.getAddedInvestment(investmentService.saveInvestment(investmentDTO));
    }
}
