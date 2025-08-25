package com.amandaleopoldoo.postocombustivel.infraestructure.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tipos_de_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome; // Ex: "Gasolina", "Etanol"

    @Column(name = "preco_por_litro")
    private BigDecimal precoPorLitro; // Usado para cálculos de valores
}
