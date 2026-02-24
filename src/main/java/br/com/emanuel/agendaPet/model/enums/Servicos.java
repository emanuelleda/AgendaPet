package br.com.emanuel.agendaPet.model.enums;

import java.math.BigDecimal;

public enum Servicos {

    BANHO("Banho Simples", new BigDecimal("50.00"), 30),
    TOSA("Tosa Completa", new BigDecimal("80.00"), 60),
    BANHO_E_TOSA("Banho e Tosa", new BigDecimal("120.00"), 90),
    CONSULTA_VETERINARIA("Consulta Veterinária", new BigDecimal("150.00"), 45),
    CORTE_DE_UNHAS("Corte de Unhas", new BigDecimal("20.00"), 15);

    private final String descricao;
    private final BigDecimal preco;
    private final int duracaoMinutos;


    Servicos(String descricao, BigDecimal preco, int duracaoMinutos) {
        this.descricao = descricao;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getDescricao() { return descricao; }
    public BigDecimal getPreco() { return preco; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
}
