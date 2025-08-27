package com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.TipoDeCombustivel;
import lombok.Data;

@Data
public class BombaDeCombustivelRequestDTO {
    private String nome;
    private TipoDeCombustivel tipodeCombustivel;
}
