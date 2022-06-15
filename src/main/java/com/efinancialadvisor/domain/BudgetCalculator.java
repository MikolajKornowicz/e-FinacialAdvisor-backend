package com.efinancialadvisor.domain;

import com.efinancialadvisor.controller.BudgetNotFoundException;
import com.efinancialadvisor.service.DbService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
@Getter
public class BudgetCalculator {

    private final DbService service;

    public int calculateExpenses (Long userId) throws BudgetNotFoundException {

        int total = 0;
        List<Integer> listExpenses = new ArrayList<>();

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

        for (int amount : listExpenses){
            total = total + (amount);
        }
        return total;
    }

    public int calculateNetIncome (long userId) throws BudgetNotFoundException {
        int income = service.getBudget(userId).getIncome();
        int expenses = service.getBudget(userId).getExpenses();
        int net = income - expenses;

        return net;
    }
}
