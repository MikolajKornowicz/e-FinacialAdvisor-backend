package com.efinancialadvisor.controller;

import com.efinancialadvisor.domain.*;
import com.efinancialadvisor.mapper.BudgetMapper;
import com.efinancialadvisor.service.DbService;
import com.efinancialadvisor.service.LoginAuthenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.awt.*;
import java.math.BigDecimal;
import java.net.Authenticator;
import java.nio.file.attribute.UserPrincipal;
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
    private final LoginAuthenticator authenticator;

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
    public String getExpenses (@PathVariable Long userId) throws BudgetNotFoundException {
        return String.valueOf(budgetCalculator.calculateExpenses(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/rent/{userId}")
    public BigDecimal getRent (@PathVariable Long userId) throws BudgetNotFoundException {
        return new BigDecimal(String.valueOf(service.getBudget(userId).getRent()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/netincome/{userId}")
    public String getNetIncome (@PathVariable Long userId) throws BudgetNotFoundException {
        return String.valueOf(budgetCalculator.calculateNetIncome(userId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/budget/{userId}")
    public void deleteBudget (Long userId) {
                service.deleteBudgetByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/budget")
    public BudgetDto updateBudget(@RequestBody BudgetDto budgetDto){
        return budgetMapper.mapToBudgetDto(service.saveBudget(budgetMapper.mapToBudget(budgetDto)));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/budget", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void updateBudget(@RequestBody CreatedBudgetDto createdBudgetDto){
        Budget budget = budgetMapper.mapCreatedIntoBudget(createdBudgetDto);
        service.saveBudget(budget);
        }

    @RequestMapping(method = RequestMethod.POST, value = "/budget/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getCredentials (@RequestBody UserDto user) {
        try{
            boolean result = authenticator.authenticate(user.getUsername(), user.getPassword());
            if (result){
                UserDto authenticatedUser = new UserDto(user.getUserId(), user.getUsername(), user.getPassword());
                return authenticatedUser;
            } else {
                return new UserDto(0L, "UnknownUser", "UnknownUser");
            }
    } catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        return new UserDto(0L, "UnknownUser", "UnknownUser");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/budget/user/{username}")
    public ResponseEntity<BudgetDto> getBudgetByUsername (@PathVariable String username) throws BudgetNotFoundException {
        return new ResponseEntity<>(budgetMapper.mapToBudgetDto(
                service.getBudgetByUsername(username)), HttpStatus.OK);
    }
}
