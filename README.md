# ⛽️ Desafio Posto de Combustível

![Java](https://img.shields.io/badge/Java-21-blue?logo=java&style=for-the-badge) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.x-brightgreen?logo=springboot&style=for-the-badge) 
![H2 Database](https://img.shields.io/badge/H2-Database-blueviolet?logo=h2&style=for-the-badge) 
![Docker](https://img.shields.io/badge/Docker-ready-blue?logo=docker&style=for-the-badge) 
![API Doc](https://img.shields.io/badge/docs-Swagger_UI-orange?logo=swagger&style=for-the-badge) 
![License: Free Use](https://img.shields.io/badge/license-free--to--use-lightgrey?style=for-the-badge)

API para gestão de abastecimentos em um posto de combustível 🚗💨  
> **Este projeto foi desenvolvido para testar meus conhecimentos em Java, Spring Boot, JPA/Hibernate e bancos de dados relacionais.**

O objetivo é permitir o controle de bombas, tipos de combustível e registros de abastecimentos em uma API RESTful.

---

## ⚙️ Funcionalidades

- 🛢️ Cadastro e consulta de **bombas de combustível**
- ⛽ Cadastro e consulta de **tipos de combustível**
- 📝 Registro e consulta de **abastecimentos**
- 📈 Consulta de histórico por bomba ou período
- 📄 API RESTful documentada via **OpenAPI/Swagger**
- 💾 Banco de dados em memória (**H2**) para facilitar testes e desenvolvimento

---

## 🧰 Tecnologias Utilizadas

- ☕ Java 21
- 🌱 Spring Boot 3.5.x
- 🗄️ Spring Data JPA
- 💽 H2 Database
- 🔥 Lombok
- 🔍 OpenAPI / Swagger
- 🐳 Docker (opcional)

---

## ▶️ Como rodar o projeto

### Pré-requisitos

- Java 21+
- Maven 3.9+
- (Opcional) Docker

### Executando via Maven

```bash
git clone https://github.com/AmandaLeopoldoo/Desafio_PostoDeCombustivel.git
cd Desafio_PostoDeCombustivel
mvn spring-boot:run
```
O servidor irá rodar na porta `8080`.

---

### 💻 Acessando o H2 Console

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:file:./data/postoDB`
- Usuário: `Amanda`
- Senha: (em branco)

---

### 📃 Documentação da API (Swagger)

Após subir o projeto, acesse:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Ou: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📦 Exemplos de Endpoints

- `GET /api/bombas` — Lista todas as bombas
- `POST /api/bombas` — Cadastra uma nova bomba
- `GET /api/combustiveis` — Lista tipos de combustível
- `POST /api/abastecimentos` — Registra um novo abastecimento
- `GET /api/abastecimentos?bombaId=1` — Consulta abastecimentos por bomba

Consulte a documentação Swagger para ver todos os endpoints e exemplos de payloads.

---

## 🗂️ Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │    └── com/
     │          └── amandaleopoldoo/
     │                └── postocombustivel/
     │                     ├── controller/          # Controllers REST (pontos de entrada da API)
     │                     ├── dtos/                # Data Transfer Objects
     │                     ├── infrastructure/
     │                     │     ├── entities/      # Entidades JPA
     │                     │     └── repositories/  # Repositórios Spring Data JPA
     │                     ├── service/             # Serviços (regras de negócio)
     │                     └── PostocombustivelApplication # Classe principal do Spring Boot
     └── resources/                           
           └── application.properties   

```

## 🐋 Rodando com Docker

Se desejar, utilize o Docker para rodar a aplicação:

```bash
docker build -t postocombustivel .
docker run -p 8080:8080 postocombustivel
```

---

## 🧪 Testes

Os testes unitários e de integração podem ser executados com:

```bash
mvn test
```

---

## 👩‍💻 Autora

Amanda Leopoldo  
www.linkedin.com/in/amandaleopoldo

---

## 📝 Licença

Este projeto é livre para fins de estudo e uso acadêmico.
