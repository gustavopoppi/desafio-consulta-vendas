package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class SaleReportDTO {

    private Long id;
    private LocalDate data;
    private Double amount;
    private String nomeVendedor;

    public SaleReportDTO(Long id, LocalDate data, Double amount, String nomeVendedor) {
        this.id = id;
        this.data = data;
        this.amount = amount;
        this.nomeVendedor = nomeVendedor;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getAmount() {
        return amount;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }
}