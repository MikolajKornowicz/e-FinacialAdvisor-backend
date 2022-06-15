package com.efinancialadvisor.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class BudgetDto {

    private Long userId;
    private int income;
    private int expenses;
    private int netIncome;
    private int rent;
    private int utilities;
    private int phone;
    private int gas;
    private int food;
    private int cosmetics;
    private int clothes;
    private int education;
    private int sports;
    private int hobby;
    private int alimony;
    private int healthcare;
    private int holidays;
    private int car_insurance;
    private int house_insurance;
    private int personal_insurance;
    private int loans;
    private int other;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

}
