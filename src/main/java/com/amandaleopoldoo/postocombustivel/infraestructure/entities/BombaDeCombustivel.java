package com.amandaleopoldoo.postocombustivel.infraestructure.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bombas_de_Combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombaDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne // Muitas bombas podem ter um tipo de combustível (ex: várias bombas de gasolina)
    @JoinColumn(name = "combustivel_id")
    private TipoDeCombustivel tipoDeCombustivel;
}
