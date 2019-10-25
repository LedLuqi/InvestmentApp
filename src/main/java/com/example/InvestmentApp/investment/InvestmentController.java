package com.example.InvestmentApp.investment;

import com.example.InvestmentApp.investment.AddedInvestment;
import com.example.InvestmentApp.investment.InvestmentDTO;
import com.example.InvestmentApp.investment.InvestmentInfo;
import com.example.InvestmentApp.investment.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AddedInvestment> addInvestmentAndGetView(@RequestBody InvestmentDTO investmentDTO) {
        //return investmentService.getAddedInvestment(investmentService.saveInvestment(investmentDTO));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(investmentService.getAddedInvestment(investmentService.saveInvestment(investmentDTO)));
    }
}
