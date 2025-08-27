package com.amandaleopoldoo.postocombustivel.controller;

import com.amandaleopoldoo.postocombustivel.dtos.Abastecimento.AbastecimentoResponseDTO;
import com.amandaleopoldoo.postocombustivel.dtos.bombaDeCombustivel.BombaDeCombustivelResponseDTO;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.Abastecimento;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import com.amandaleopoldoo.postocombustivel.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/abastecimento")
@RequiredArgsConstructor
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    // POST para realizar um abastecimento
    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam Long litros,@RequestParam Integer idBomba) {
        abastecimentoService.abastecer(idBomba, litros);
        try {
            abastecimentoService.abastecer(idBomba, litros);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            e.printStackTrace(); // loga o erro no terminal/log do docker
            return ResponseEntity.status(500).build();
        } // Retorna 202 Accepted
    }

    // GET para buscar todos os abastecimentos
    @GetMapping
    public ResponseEntity<List<AbastecimentoResponseDTO>> buscarAbastecimentos() {
        List<Abastecimento> abastecimentos = abastecimentoService.buscarAbastecimentos();
        List<AbastecimentoResponseDTO> dtos = new ArrayList<>();
        for (Abastecimento abastecimento : abastecimentos) {
            AbastecimentoResponseDTO dto = toResponseDTO(abastecimento);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos); // Retorna 200 OK com a lista de abastecimentos
    }

    // Converte uma entidade TipoDeCombustivel em um TipoDeCombustivelResponseDTO.
    // Usado para devolver ao cliente apenas os dados necessários, seguindo o padrão de resposta da API.
    private AbastecimentoResponseDTO toResponseDTO(Abastecimento entity) {
        AbastecimentoResponseDTO dto = new AbastecimentoResponseDTO();
        dto.setId(entity.getId());
        dto.setDataDoAbastecimento(entity.getDataDoAbastecimento());
        dto.setQuantidadeDelitros(entity.getQuantidadeDelitros());
        dto.setValorTotal(entity.getValorTotal());

        if (entity.getBombaDeCombustivel() != null) {
            dto.setBombaDeCombustivel(toResponseDTO(entity.getBombaDeCombustivel()));
        }
        return dto;
    }

    // Converte uma entidade BombaDeCombustivel em um DTO de resposta da bomba
    private BombaDeCombustivelResponseDTO toResponseDTO(BombaDeCombustivel entity) {
        BombaDeCombustivelResponseDTO dto = new BombaDeCombustivelResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTipoDeCombustivel(entity.getTipoDeCombustivel());
        return dto;
    }
}

