package com.amandaleopoldoo.postocombustivel.infraestructure.repositories;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaDeCombustivelRepository extends JpaRepository<BombaDeCombustivel, Integer> {

}
