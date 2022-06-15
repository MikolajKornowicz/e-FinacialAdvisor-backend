package com.efinancialadvisor.mapper;

import com.efinancialadvisor.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetMapper {


    public BudgetDto mapToBudgetDto (Budget budget){
        return new BudgetDto(
                budget.getUserId(),
                budget.getIncome(),
                budget.getExpenses(),
                budget.getNetIncome(),
                budget.getRent(),
                budget.getUtilities(),
                budget.getPhone(),
                budget.getGas(),
                budget.getFood(),
                budget.getCosmetics(),
                budget.getClothes(),
                budget.getEducation(),
                budget.getSports(),
                budget.getHobby(),
                budget.getAlimony(),
                budget.getHealthcare(),
                budget.getHolidays(),
                budget.getCar_insurance(),
                budget.getHouse_insurance(),
                budget.getPersonal_insurance(),
                budget.getLoans(),
                budget.getOther(),
                budget.getUsername(),
                budget.getPassword(),
                budget.getEmail(),
                budget.getName(),
                budget.getSurname()
        );
    }

    public Budget mapToBudget(BudgetDto budgetDto){
        return new Budget(
                budgetDto.getUserId(),
                budgetDto.getIncome(),
                budgetDto.getExpenses(),
                budgetDto.getNetIncome(),
                budgetDto.getRent(),
                budgetDto.getUtilities(),
                budgetDto.getPhone(),
                budgetDto.getGas(),
                budgetDto.getFood(),
                budgetDto.getCosmetics(),
                budgetDto.getClothes(),
                budgetDto.getEducation(),
                budgetDto.getSports(),
                budgetDto.getHobby(),
                budgetDto.getAlimony(),
                budgetDto.getHealthcare(),
                budgetDto.getHolidays(),
                budgetDto.getCar_insurance(),
                budgetDto.getHouse_insurance(),
                budgetDto.getPersonal_insurance(),
                budgetDto.getLoans(),
                budgetDto.getOther(),
                budgetDto.getUsername(),
                budgetDto.getPassword(),
                budgetDto.getEmail(),
                budgetDto.getName(),
                budgetDto.getSurname()
        );
    }

    public List<BudgetDto> mapToBudgetDtoList(final List<Budget> budgets){
        return budgets.stream().map(this::mapToBudgetDto).collect(Collectors.toList());
    }


    public Budget mapCreatedIntoBudget (CreatedBudgetDto  budgetDto){

        return new Budget(
                budgetDto.getUserId(),
                budgetDto.getIncome(),
                budgetDto.getExpenses(),
                budgetDto.getNetIncome(),
                budgetDto.getRent(),
                budgetDto.getUtilities(),
                budgetDto.getPhone(),
                budgetDto.getGas(),
                budgetDto.getFood(),
                budgetDto.getCosmetics(),
                budgetDto.getClothes(),
                budgetDto.getEducation(),
                budgetDto.getSports(),
                budgetDto.getHobby(),
                budgetDto.getAlimony(),
                budgetDto.getHealthcare(),
                budgetDto.getHolidays(),
                budgetDto.getCar_insurance(),
                budgetDto.getHouse_insurance(),
                budgetDto.getPersonal_insurance(),
                budgetDto.getLoans(),
                budgetDto.getOther(),
                budgetDto.getUsername(),
                budgetDto.getPassword(),
                budgetDto.getEmail(),
                budgetDto.getName(),
                budgetDto.getSurname()
        );
    }

    public UserDto mapBudgetToUserDto(Optional<Budget> budget){
        return new UserDto(
                budget.get().getUserId(),
                budget.get().getUsername(),
                budget.get().getPassword()
        );
    }

}
