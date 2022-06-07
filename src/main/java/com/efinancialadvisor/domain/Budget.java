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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "budget")
public class Budget {

    @Id
    @GeneratedValue
    private Long userId;
    @Column(name = "income", nullable = false, columnDefinition = "int default 0 not null")
    private BigDecimal income;
    @Column(name = "expenses",nullable = false, columnDefinition = "int default 0 not null")
    private BigDecimal expenses;
    @Column(name = "net_Income", nullable = false, columnDefinition = "int default 0 not null")
    private BigDecimal netIncome;
    @Column(name = "rent", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal rent;
    @Column(name = "utilities", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal utilities;
    @Column(name = "phone", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal phone;
    @Column(name = "gas", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal gas;
    @Column(name = "food", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal food;
    @Column(name = "cosmetics", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal cosmetics;
    @Column(name = "clothes", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal clothes;
    @Column(name = "education", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal education;
    @Column(name = "sports", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal sports;
    @Column(name = "hobby", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal hobby;
    @Column(name = "alimony", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal alimony;
    @Column(name = "healthcare", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal healthcare;
    @Column(name = "holidays", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal holidays;
    @Column(name = "car_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal car_insurance;
    @Column(name = "house_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal house_insurance;
    @Column(name = "personal_insurance", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal personal_insurance;
    @Column(name = "loans", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal loans;
    @Column(name = "other", nullable = false,  columnDefinition = "int default 0 not null")
    private BigDecimal other;

}
