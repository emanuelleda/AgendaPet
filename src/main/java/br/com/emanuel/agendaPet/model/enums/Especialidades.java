package br.com.emanuel.agendaPet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especialidades {
    VETERINARIO,
    TOSADOR;

    @JsonCreator
    public static Especialidades fromValue(String value) {
        return Especialidades.valueOf(value.toUpperCase());
    }
}