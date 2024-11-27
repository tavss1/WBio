package com.example.ifsp.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthenticationDTO(@JsonAlias("login") String login, @JsonAlias("password") String password) {
}
