package com.efinancialadvisor.service;

import com.efinancialadvisor.domain.BudgetDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NewAccountValidator {

    private DbService service;

    public boolean validateNewAccount (BudgetDto budgetDto){
        return service.getByUserName(budgetDto.getUsername()).isEmpty();
    }
}
