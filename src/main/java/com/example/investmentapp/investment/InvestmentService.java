package com.example.investmentapp.investment;

import com.example.investmentapp.investment.data.AddedInvestment;
import com.example.investmentapp.investment.data.Investment;
import com.example.investmentapp.investment.data.InvestmentDTO;
import com.example.investmentapp.investment.data.InvestmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvestmentService {

    private InvestmentRepository repository;

    @Autowired
    public InvestmentService(InvestmentRepository repository) {
        this.repository = repository;
    }

    Investment saveInvestment (InvestmentDTO investmentDTO){
           return repository.save(new Investment(investmentDTO.getName(),investmentDTO.getInterest(),
                   investmentDTO.getCapitalization(),investmentDTO.getDateOfStart(),investmentDTO.getDateOfEnd()));
    }

    List<InvestmentInfo> getInvestmentInfoList () {
        return repository.findAll().stream()
                .map(x -> new InvestmentInfo(x.getId(),x.getName()))
                .collect(Collectors.toList());
    }

    public Investment getInvestmentById (Long id){
        return repository.findById(id).get();
    }

    Long getDuration (LocalDate dateOfStart, LocalDate dateOfEnd){
        return ChronoUnit.DAYS.between(dateOfStart,dateOfEnd);
    }

    AddedInvestment getAddedInvestment(Investment investment){
         AddedInvestment addedInvestment = new AddedInvestment(investment.getId(),investment.getName(),investment.getInterest(),
                getDuration(investment.getDateOfStart(),investment.getDateOfEnd()));
        return addedInvestment;
    }
}
