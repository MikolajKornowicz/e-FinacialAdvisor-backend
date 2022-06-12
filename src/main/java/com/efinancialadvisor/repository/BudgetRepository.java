package com.efinancialadvisor.repository;

import com.efinancialadvisor.domain.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {

    @Override
    List<Budget> findAll();

    @Override
    Budget save(Budget budget);

    Optional<Budget>findByUserId(Long userId);

    void deleteBudgetByUserId(Long userId);

    Optional<Budget> findByUsername (String username);


}
