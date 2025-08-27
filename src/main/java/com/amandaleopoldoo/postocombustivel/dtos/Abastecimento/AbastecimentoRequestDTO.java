package com.amandaleopoldoo.postocombustivel.dtos.Abastecimento;

import com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel.BombaDeCombustivelResponseDTO;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AbastecimentoRequestDTO {
    private BombaDeCombustivelResponseDTO bombaDeCombustivel;
    private LocalDate dataDoAbastecimento;
    private Long quantidadeDelitros;
    private BigDecimal valorTotal;
}
