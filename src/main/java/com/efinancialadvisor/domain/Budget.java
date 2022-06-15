package com.efinancialadvisor.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "budget")
public class Budget {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "income", nullable = false, columnDefinition = "int default 0 not null")
    private int income;
    @Column(name = "expenses",nullable = false, columnDefinition = "int default 0 not null")
    private int expenses;
    @Column(name = "net_Income", nullable = false, columnDefinition = "int default 0 not null")
    private int netIncome;
    @Column(name = "rent", nullable = false,  columnDefinition = "int default 0 not null")
    private int rent;
    @Column(name = "utilities", nullable = false,  columnDefinition = "int default 0 not null")
    private int utilities;
    @Column(name = "phone", nullable = false,  columnDefinition = "int default 0 not null")
    private int phone;
    @Column(name = "gas", nullable = false,  columnDefinition = "int default 0 not null")
    private int gas;
    @Column(name = "food", nullable = false,  columnDefinition = "int default 0 not null")
    private int food;
    @Column(name = "cosmetics", nullable = false,  columnDefinition = "int default 0 not null")
    private int cosmetics;
    @Column(name = "clothes", nullable = false,  columnDefinition = "int default 0 not null")
    private int clothes;
    @Column(name = "education", nullable = false,  columnDefinition = "int default 0 not null")
    private int education;
    @Column(name = "sports", nullable = false,  columnDefinition = "int default 0 not null")
    private int sports;
    @Column(name = "hobby", nullable = false,  columnDefinition = "int default 0 not null")
    private int hobby;
    @Column(name = "alimony", nullable = false,  columnDefinition = "int default 0 not null")
    private int alimony;
    @Column(name = "healthcare", nullable = false,  columnDefinition = "int default 0 not null")
    private int healthcare;
    @Column(name = "holidays", nullable = false,  columnDefinition = "int default 0 not null")
    private int holidays;
    @Column(name = "car_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private int car_insurance;
    @Column(name = "house_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private int house_insurance;
    @Column(name = "personal_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private int personal_insurance;
    @Column(name = "loans", nullable = false,  columnDefinition = "int default 0 not null")
    private int loans;
    @Column(name = "other", nullable = false,  columnDefinition = "int default 0 not null")
    private int other;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;


}

