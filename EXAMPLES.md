# 📚 Exemplos de Uso da API

Aqui estão exemplos práticos de requisições para os principais endpoints da API de Posto de Combustível, **incluindo o campo `valorTotal`**.

---

## 🛢️ Bombas

### Listar todas as bombas

```bash
curl -X GET http://localhost:8080/api/bombas
```

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Bomba 1",
    "tipoCombustivel": "GASOLINA"
  },
  {
    "id": 2,
    "nome": "Bomba 2",
    "tipoCombustivel": "ETANOL"
  }
]
```

---

### Cadastrar uma nova bomba

```bash
curl -X POST http://localhost:8080/api/bombas \
  -H "Content-Type: application/json" \
  -d '{"nome": "Bomba 3", "tipoCombustivel": "DIESEL"}'
```

**Resposta:**
```json
{
  "id": 3,
  "nome": "Bomba 3",
  "tipoCombustivel": "DIESEL"
}
```

---

## 📝 Abastecimentos

### Registrar um novo abastecimento

```bash
curl -X POST "http://localhost:8080/api/abastecimento?litros=40&idBomba=1"
```

**Resposta:**
```json
{
  "id": 1,
  "bombaDeCombustivel": {
    "id": 1,
    "nome": "Bomba 1",
    "tipoDeCombustivel": {
      "id": 1,
      "nome": "GASOLINA",
      "precoPorLitro": 5.00
    }
  },
  "dataDoAbastecimento": "2025-08-27",
  "quantidadeDelitros": 40,
  "valorTotal": 200.00
}
```

---

### Listar abastecimentos

```bash
curl -X GET http://localhost:8080/api/abastecimento
```

**Resposta:**
```json
[
  {
    "id": 1,
    "bombaDeCombustivel": {
      "id": 1,
      "nome": "Bomba 1",
      "tipoDeCombustivel": {
        "id": 1,
        "nome": "GASOLINA",
        "precoPorLitro": 5.00
      }
    },
    "dataDoAbastecimento": "2025-08-27",
    "quantidadeDelitros": 40,
    "valorTotal": 200.00
  }
]
```

---

## 📄 Documentação Interativa

Consulte e teste todos os endpoints via Swagger em:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
