package com.efinancialadvisor.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

}

