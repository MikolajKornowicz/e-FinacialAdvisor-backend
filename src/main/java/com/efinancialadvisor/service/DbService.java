package com.efinancialadvisor.service;

import com.efinancialadvisor.controller.BudgetNotFoundException;
import com.efinancialadvisor.domain.Budget;
import com.efinancialadvisor.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BudgetRepository repository;


    public List<Budget> getAllBudgets () {
        return repository.findAll();
    }

    public Budget saveBudget (final  Budget  budget){
        return repository.save(budget);
    }

    public Budget getBudget(final Long userId) throws BudgetNotFoundException {
        return repository.findByUserId(userId).orElseThrow(BudgetNotFoundException::new);
    }

    public void deleteBudgetByUserId (final Long userId) {
        repository.deleteBudgetByUserId(userId);
    }

}
