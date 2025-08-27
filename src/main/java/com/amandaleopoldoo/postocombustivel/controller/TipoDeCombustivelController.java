package com.amandaleopoldoo.postocombustivel.controller;

import com.amandaleopoldoo.postocombustivel.dtos.tipoDeCombustivel.TipoDeCombustivelRequestDTO;
import com.amandaleopoldoo.postocombustivel.dtos.tipoDeCombustivel.TipoDeCombustivelResponseDTO;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.TipoDeCombustivel;
import com.amandaleopoldoo.postocombustivel.service.TipoDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tipos-de-combustivel")
@RequiredArgsConstructor
public class TipoDeCombustivelController {

    private final TipoDeCombustivelService tipoDeCombustivelService;

    @PostMapping
    public ResponseEntity<TipoDeCombustivelResponseDTO> criar(@RequestBody TipoDeCombustivelRequestDTO dto) {
        TipoDeCombustivel entity = toEntity(dto);
        TipoDeCombustivel novoTipo = tipoDeCombustivelService.criar(entity);
        return ResponseEntity.ok(toResponseDTO(novoTipo));
    }

    @GetMapping
    public ResponseEntity<List<TipoDeCombustivelResponseDTO>> buscarTiposDeCombustivel() {
        List<TipoDeCombustivel> tipos = tipoDeCombustivelService.buscarTiposDeCombustiveis();
        List<TipoDeCombustivelResponseDTO> dtos = new ArrayList<>();
        for (TipoDeCombustivel tipo : tipos) {
            TipoDeCombustivelResponseDTO dto = toResponseDTO(tipo);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelResponseDTO> buscarTipoDeCombustivelPorId(@PathVariable Integer id){
        TipoDeCombustivel tipo = tipoDeCombustivelService.buscarTipoDeCombustivelPorId(id);
        return ResponseEntity.ok(toResponseDTO(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelResponseDTO> alterarTipoDeCombustivel(@PathVariable Integer id, @RequestBody TipoDeCombustivelRequestDTO dto) {
        TipoDeCombustivel entity = toEntity(dto);
        entity.setId(id);
        TipoDeCombustivel tipoAtualizado = tipoDeCombustivelService.alterarTipoDeCombustivel(entity);
        return ResponseEntity.ok(toResponseDTO(tipoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoDeCombustivel(@PathVariable Integer id) {
        tipoDeCombustivelService.deletarTipoDeCombustivelPorId(id);
        return ResponseEntity.ok().build();
    }

    // Converte um TipoDeCombustivelRequestDTO em uma entidade TipoDeCombustivel.
    // Usado para transformar dados recebidos na requisição em um objeto compatível com o banco.
    private TipoDeCombustivel toEntity(TipoDeCombustivelRequestDTO dto) {
        TipoDeCombustivel entity = new TipoDeCombustivel();
        entity.setNome(dto.getNome());
        entity.setPrecoPorLitro(dto.getPrecoPorLitro());
        return entity;
    }

    // Converte uma entidade TipoDeCombustivel em um TipoDeCombustivelResponseDTO.
    // Usado para devolver ao cliente apenas os dados necessários, seguindo o padrão de resposta da API.
    private TipoDeCombustivelResponseDTO toResponseDTO(TipoDeCombustivel entity) {
        TipoDeCombustivelResponseDTO dto = new TipoDeCombustivelResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setPrecoPorLitro(entity.getPrecoPorLitro());
        return dto;
    }









}
