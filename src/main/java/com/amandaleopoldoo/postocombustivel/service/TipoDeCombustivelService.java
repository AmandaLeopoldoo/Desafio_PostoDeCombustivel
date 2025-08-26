package com.amandaleopoldoo.postocombustivel.service;

import com.amandaleopoldoo.postocombustivel.infraestructure.repositories.TipoDeCombustivelRepository;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.TipoDeCombustivel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public TipoDeCombustivel criar(TipoDeCombustivel tipoDeCombustivel){
        return tipoDeCombustivelRepository.save(tipoDeCombustivel);
    }

    public List<TipoDeCombustivel> buscarTiposDeCombustiveis(){
        return tipoDeCombustivelRepository.findAll();
    }

    public TipoDeCombustivel buscarTipoDeCombustivelPorId(Integer id){
        return tipoDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Tipo de combustivel não encontrado pelo id" + id));
    }

    @Transactional
    public void deletarTipoDeCombustivelPorId(Integer id){
        tipoDeCombustivelRepository.deleteById(id);
    }

    public TipoDeCombustivel alterarTipoDeCombustivel(TipoDeCombustivel tipoDeCombustivel){
        TipoDeCombustivel existente = buscarTipoDeCombustivelPorId(tipoDeCombustivel.getId());
        existente.setNome(tipoDeCombustivel.getNome());
        existente.setPrecoPorLitro(tipoDeCombustivel.getPrecoPorLitro());
        return tipoDeCombustivelRepository.save(existente);
    }



}
