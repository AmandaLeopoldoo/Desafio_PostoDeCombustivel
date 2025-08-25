package com.amandaleopoldoo.postocombustivel.infraestructure.repositories;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.Abastecimento;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.TipoDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository  extends JpaRepository<Abastecimento, Integer> {

}
