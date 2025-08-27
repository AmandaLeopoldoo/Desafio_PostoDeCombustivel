package com.amandaleopoldoo.postocombustivel.infraestructure.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bomba_id")
    private BombaDeCombustivel bombaDeCombustivel;

    @Column(name = "data_abastecimento")
    private LocalDate dataDoAbastecimento;

    @Column(name = "quantidade_litros")
    private Long quantidadeDelitros;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;



}
