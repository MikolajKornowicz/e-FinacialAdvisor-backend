package com.efinancialadvisor.service;

import com.efinancialadvisor.controller.BudgetNotFoundException;
import com.efinancialadvisor.domain.Budget;
import com.efinancialadvisor.domain.UserDto;
import com.efinancialadvisor.mapper.BudgetMapper;
import com.efinancialadvisor.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BudgetRepository repository;
    private final BudgetMapper mapper;


    public List<Budget> getAllBudgets() {
        return repository.findAll();
    }

    public Budget saveBudget(final Budget budget) {
        return repository.save(budget);
    }

    public Budget getBudget(final Long userId) throws BudgetNotFoundException {
        return repository.findByUserId(userId).orElseThrow(BudgetNotFoundException::new);
    }

    public void deleteBudgetByUserId(final Long userId) {
        repository.deleteBudgetByUserId(userId);
    }

    public Optional<UserDto> getByUserName(final String username) {
        try {
            Optional<UserDto> userDto = Optional.ofNullable(mapper.mapBudgetToUserDto(repository.findByUsername(username)));
                return userDto;
    } catch (NoSuchElementException e){
        return Optional.empty();
        }
    }

    public Budget getBudgetByUsername (final String username) throws BudgetNotFoundException{
        return repository.findByUsername(username).orElseThrow(BudgetNotFoundException::new);
    }
}
