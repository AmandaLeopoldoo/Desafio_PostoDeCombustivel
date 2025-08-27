package com.amandaleopoldoo.postocombustivel.dtos.tipoDeCombustivel;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TipoDeCombustivelRequestDTO {
    private String nome;
    private BigDecimal precoPorLitro;
}
