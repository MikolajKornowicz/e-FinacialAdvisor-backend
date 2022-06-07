package com.efinancialadvisor.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BudgetDto {

    private Long userId;
    private BigDecimal income;
    private BigDecimal expenses;
    private BigDecimal netIncome;
    private BigDecimal rent;
    private BigDecimal utilities;
    private BigDecimal phone;
    private BigDecimal gas;
    private BigDecimal food;
    private BigDecimal cosmetics;
    private BigDecimal clothes;
    private BigDecimal education;
    private BigDecimal sports;
    private BigDecimal hobby;
    private BigDecimal alimony;
    private BigDecimal healthcare;
    private BigDecimal holidays;
    private BigDecimal car_insurance;
    private BigDecimal house_insurance;
    private BigDecimal personal_insurance;
    private BigDecimal loans;
    private BigDecimal other;


}
