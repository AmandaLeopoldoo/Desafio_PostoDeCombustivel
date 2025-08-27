package com.amandaleopoldoo.postocombustivel.dtos.tipoDeCombustivel;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TipoDeCombustivelResponseDTO {
    private Integer id;
    private String nome;
    private BigDecimal precoPorLitro;


}


