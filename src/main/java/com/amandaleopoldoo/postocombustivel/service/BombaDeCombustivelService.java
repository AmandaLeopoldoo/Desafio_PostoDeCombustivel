package com.amandaleopoldoo.postocombustivel.service;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import com.amandaleopoldoo.postocombustivel.infraestructure.repositories.BombaDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    // Criar uma nova bomba de combustivel
    public BombaDeCombustivel criar(BombaDeCombustivel bombaCombustivel){
        return bombaDeCombustivelRepository.save(bombaCombustivel);
    }

    // Listar todas a bombas de combustivel
    public List<BombaDeCombustivel> buscarBombasDeCombustivel(){
        return bombaDeCombustivelRepository.findAll();
    }

    // Buscar bomba por id
    public BombaDeCombustivel buscarBombaCombustivelPorId(Integer id){
        return bombaDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Bomba de combustível não encontrada pelo ID: " + id));
    }

    // Deletar bomba
    @Transactional // Garante a atomicidade da operação de exclusão
    public void deletarBombaDeCombustivelPorId(Integer id){
        bombaDeCombustivelRepository.deleteById(id);
    }

    // Alternar Bomba de Combustivel
    public BombaDeCombustivel alterarBombaCombustivel(BombaDeCombustivel bombaCombustivel){
        // Primeiro busca a bomba existente para validar sua existência
        BombaDeCombustivel bombaEscolhida = buscarBombaCombustivelPorId(bombaCombustivel.getId());
        // Atualiza os campos da bomba existente
        bombaEscolhida.setNome(bombaCombustivel.getNome());
        bombaEscolhida.setTipoDeCombustivel(bombaCombustivel.getTipoDeCombustivel());
        // Salva a bomba atualizada
        return bombaDeCombustivelRepository.save(bombaEscolhida);
    }
}
