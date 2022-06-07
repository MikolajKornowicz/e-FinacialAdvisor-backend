package com.efinancialadvisor.controller;

import com.efinancialadvisor.domain.Budget;
import com.efinancialadvisor.domain.BudgetCalculator;
import com.efinancialadvisor.domain.BudgetDto;
import com.efinancialadvisor.mapper.BudgetMapper;
import com.efinancialadvisor.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/")
@CrossOrigin(origins = "*")
public class EfaController {

    private final DbService service;
    private final BudgetMapper budgetMapper;
    private final BudgetCalculator budgetCalculator;


    @RequestMapping(method = RequestMethod.GET, value = "budget")
    public List<BudgetDto> getAllBudgets () {
        List<Budget> budgets = service.getAllBudgets();
        return budgetMapper.mapToBudgetDtoList(budgets);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/{userId}")
    public ResponseEntity<BudgetDto> getBudget (@PathVariable Long userId) throws BudgetNotFoundException {
        return new ResponseEntity<>(budgetMapper.mapToBudgetDto(
                service.getBudget(userId)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/expenses/{userId}")
    public BigDecimal getExpenses (@PathVariable Long userId) throws BudgetNotFoundException {
        return new BigDecimal(String.valueOf(budgetCalculator.calculateExpenses(userId)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/rent/{userId}")
    public BigDecimal getRent (@PathVariable Long userId) throws BudgetNotFoundException {
        return new BigDecimal(String.valueOf(service.getBudget(userId).getRent()));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/budget/{userId}")
    public void deleteBudget (Long userId) {
                service.deleteBudgetByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/budget")
    public BudgetDto updateBudget(@RequestBody BudgetDto budgetDto){
        return budgetMapper.mapToBudgetDto(service.saveBudget(budgetMapper.mapToBudget(budgetDto)));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/budget", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void createBudget(@RequestBody BudgetDto budgetDto){
        Budget budget = budgetMapper.mapToBudget(budgetDto);
        service.saveBudget(budget);
        }
}
