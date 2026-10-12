#  Aprendendo Spring Boot - API de Usuários

Projeto desenvolvido com foco em aprendizado prático de **Java + Spring Boot**, aplicando conceitos de arquitetura em camadas, segurança com JWT e boas práticas de desenvolvimento backend.

---

##  Sobre o Projeto

Esta aplicação é uma API REST para gerenciamento de usuários, contendo funcionalidades como:

- Cadastro de usuários
- Consulta de dados
- Atualização e exclusão
- Relacionamentos com endereço e telefone
- Autenticação e autorização com JWT

O projeto segue uma arquitetura organizada para simular um ambiente real de desenvolvimento.

---

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security + JWT
- Maven
- JPA / Hibernate
- REST API
- Lombok

---

##  Arquitetura do Projeto

O projeto foi estruturado seguindo boas práticas de separação de responsabilidades:

```
📁 controller        → Camada de entrada (requisições HTTP)
📁 business          → Regras de negócio (Service)
📁 infrastructure
   ├── entity        → Entidades do banco
   ├── repository    → Acesso a dados (JPA)
   ├── security      → Configurações de segurança (JWT)
   ├── exceptions    → Tratamento de erros
📁 dto               → Transferência de dados
```

---

## Segurança

A aplicação utiliza autenticação baseada em **JWT (JSON Web Token)**:

- Login gera um token
- Token é enviado nas requisições protegidas
- Filtro intercepta e valida o token

Principais classes:
- `JwtUtil`
- `JwtRequestFilter`
- `SecurityConfig`

---

## Endpoints principais

### Usuários

| Método | Endpoint          | Descrição            |
|--------|------------------|---------------------|
| GET    | `/usuarios`      | Listar usuários     |
| GET    | `/usuarios/{id}` | Buscar por ID       |
| POST   | `/usuarios`      | Criar usuário       |
| PUT    | `/usuarios/{id}` | Atualizar usuário   |
| DELETE | `/usuarios/{id}` | Deletar usuário     |

---

## Como rodar o projeto

### Pré-requisitos

- Java 17+
- Maven instalado

### Executando

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/aprendendo-spring.git

# Entrar na pasta
cd aprendendo-spring

# Rodar o projeto
./mvnw spring-boot:run
```

---

## Testando a API

Você pode testar usando:

- Postman
- Insomnia
- Curl

---

## Aprendizados aplicados

- Estruturação de API REST
- Padrão MVC no Spring
- Uso de DTOs
- Tratamento de exceções
- Autenticação com JWT
- Integração com banco de dados via JPA

---


## Autor

Desenvolvido por **Anderson Silva** 
Desenvolvedor Backend Java

---

## Contribuição

Sinta-se à vontade para contribuir ou dar sugestões!
