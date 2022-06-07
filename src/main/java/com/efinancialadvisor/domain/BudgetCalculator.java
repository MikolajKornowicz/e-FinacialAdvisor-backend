package com.efinancialadvisor.domain;

import com.efinancialadvisor.controller.BudgetNotFoundException;
import com.efinancialadvisor.service.DbService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@NoArgsConstructor
@Getter
public class BudgetCalculator {

    private BudgetDto budget;
    private DbService service;

    public BigDecimal calculateExpenses (Long userId) throws BudgetNotFoundException {

        BigDecimal total = BigDecimal.ZERO;
        List<BigDecimal> listExpenses = new ArrayList<>();
        listExpenses.add(service.getBudget(userId).getRent());
        listExpenses.add(service.getBudget(userId).getUtilities());
        listExpenses.add(service.getBudget(userId).getPhone());
        listExpenses.add(service.getBudget(userId).getGas());
        listExpenses.add(service.getBudget(userId).getFood());
        listExpenses.add(service.getBudget(userId).getCosmetics());
        listExpenses.add(service.getBudget(userId).getClothes());
        listExpenses.add(service.getBudget(userId).getEducation());
        listExpenses.add(service.getBudget(userId).getSports());
        listExpenses.add(service.getBudget(userId).getHobby());
        listExpenses.add(service.getBudget(userId).getAlimony());
        listExpenses.add(service.getBudget(userId).getHealthcare());
        listExpenses.add(service.getBudget(userId).getHolidays());
        listExpenses.add(service.getBudget(userId).getCar_insurance());
        listExpenses.add(service.getBudget(userId).getHouse_insurance());
        listExpenses.add(service.getBudget(userId).getPersonal_insurance());
        listExpenses.add(service.getBudget(userId).getLoans());
        listExpenses.add(service.getBudget(userId).getOther());

        for (BigDecimal amount : listExpenses){
            total = total.add(amount);
        }
        return total;
    }
}
