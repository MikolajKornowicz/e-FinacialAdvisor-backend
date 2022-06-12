package com.efinancialadvisor.service;

import com.efinancialadvisor.controller.BudgetNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class LoginAuthenticator {

    private DbService service;

    public boolean authenticate (String username, String password) {
            return service.getByUserName(username).isPresent() && service.getByUserName(username).get().getPassword().equals(password);
    }
}
