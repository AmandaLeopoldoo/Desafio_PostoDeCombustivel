package com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.TipoDeCombustivel;
import lombok.Data;

@Data
public class BombaDeCombustivelResponseDTO {
    private Integer id;
    private String nome;
    private TipoDeCombustivel tipoDeCombustivel;
}
