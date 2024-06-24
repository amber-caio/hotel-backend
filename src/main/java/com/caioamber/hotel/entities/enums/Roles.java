package com.caioamber.hotel.entities.enums;

import lombok.Getter;

@Getter
public enum Roles {
    ROLE_ADMIN("admin"),
    ROLE_GERENTE("gerente"),
    ROLE_FUNCIONARIO_ESTAC("funcionarioEstacionamento"),
    ROLE_FUNCIONARIO_REST("funcionarioRestaurante"),
    ROLE_FUNCIONARIO_CAIXA("funcionarioCaixa"),
    ROLE_HOSPEDE("hospede");

    private String role;

    Roles(String role) {
        this.role = role;
    }
}
