package com.amandaleopoldoo.postocombustivel.service;

import com.amandaleopoldoo.postocombustivel.infraestructure.entities.Abastecimento;
import com.amandaleopoldoo.postocombustivel.infraestructure.entities.BombaDeCombustivel;
import com.amandaleopoldoo.postocombustivel.infraestructure.repositories.AbastecimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros){
        // 1. Busca a bomba de combustível para obter seu tipo e preço por litro
        BombaDeCombustivel bomba = bombaDeCombustivelService.buscarBombaCombustivelPorId(idBomba);

        // 2. Calcula o valor total gasto
        // Multiplica o preço por litro pelo volume abastecido, usando BigDecimal
        BigDecimal valorTotal = bomba.getTipoDeCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        // 3. Cria e preenche o objeto Abastecimento
        Abastecimento abastecimento = Abastecimento.builder()
                .bombaDeCombustivel(bomba)
                .dataDoAbastecimento(LocalDate.now())
                .quantidadeDelitros(litros)
                .valorTotal(valorTotal)
                .build();

        // 4. Salva o abastecimento
        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos() {
        return abastecimentoRepository.findAll();
    }

}
