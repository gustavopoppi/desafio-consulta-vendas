package com.devsuperior.dsmeta.dto;

public class SalesSummaryBySellerDTO {

    private String nomeVendedor;
    private Double somaVendas;

    public SalesSummaryBySellerDTO(String nomeVendedor, Double somaVendas) {
        this.nomeVendedor = nomeVendedor;
        this.somaVendas = somaVendas;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public Double getSomaVendas() {
        return somaVendas;
    }
}
