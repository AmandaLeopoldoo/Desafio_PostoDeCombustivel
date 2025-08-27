package com.amandaleopoldoo.postocombustivel.controller;

import com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel.BombaDeCombustivelRequestDTO;
import com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel.BombaDeCombustivelResponseDTO;
import com.amandaleopoldoo.postocombustivel.dtos.tipoDeCombustivel.TipoDeCombustivelResponseDTO;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import com.amandaleopoldoo.postocombustivel.service.BombaDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Bombas-de-combustivel")
@RequiredArgsConstructor
public class BombaDeCombustivelController {

    private final BombaDeCombustivelService bombaDeCombustivelService;

    @PostMapping
    public ResponseEntity<BombaDeCombustivelResponseDTO> criar(@RequestBody BombaDeCombustivelRequestDTO dto){
        BombaDeCombustivel entity = toEntity(dto);
        BombaDeCombustivel novaBomba = bombaDeCombustivelService.criar(entity);
        return ResponseEntity.ok(toResponseDTO(novaBomba));
    }

    @GetMapping
    public ResponseEntity <List<BombaDeCombustivelResponseDTO>> buscarBombaDeCombustivel() {
        List<BombaDeCombustivel> bombas = bombaDeCombustivelService.buscarBombasDeCombustivel();
        List<BombaDeCombustivelResponseDTO> dtos = new ArrayList<>();
        for (BombaDeCombustivel bomba : bombas) {
            BombaDeCombustivelResponseDTO dto = toResponseDTO(bomba);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelResponseDTO> buscarBombaDeCombustivelPorId(@PathVariable Integer id) {
        BombaDeCombustivel bomba = bombaDeCombustivelService.buscarBombaCombustivelPorId(id);
        return ResponseEntity.ok(toResponseDTO(bomba));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBombaDeCombustivelPorId(@PathVariable Integer id){
        bombaDeCombustivelService.deletarBombaDeCombustivelPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelResponseDTO> alterarBombaDeCombustivel(@PathVariable Integer id, @RequestBody BombaDeCombustivelRequestDTO dto) {
        BombaDeCombustivel entity = toEntity(dto);
        entity.setId(id);
        BombaDeCombustivel bombaAtualizada = bombaDeCombustivelService.alterarBombaCombustivel(entity);
        return ResponseEntity.ok(toResponseDTO(bombaAtualizada));
    }

    // Converte um TipoDeCombustivelRequestDTO em uma entidade TipoDeCombustivel.
    // Usado para transformar dados recebidos na requisição em um objeto compatível com o banco.
    private BombaDeCombustivel toEntity(BombaDeCombustivelRequestDTO dto) {
        BombaDeCombustivel entity = new BombaDeCombustivel();
        entity.setNome(dto.getNome());
        entity.setTipoDeCombustivel(entity.getTipoDeCombustivel());
        return entity;
    }

    // Converte uma entidade TipoDeCombustivel em um TipoDeCombustivelResponseDTO.
    // Usado para devolver ao cliente apenas os dados necessários, seguindo o padrão de resposta da API.
    private BombaDeCombustivelResponseDTO toResponseDTO(BombaDeCombustivel entity) {
        BombaDeCombustivelResponseDTO dto = new BombaDeCombustivelResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTipoDeCombustivel(entity.getTipoDeCombustivel());
        return dto;
    }

}
