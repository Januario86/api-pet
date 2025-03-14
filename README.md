# Sistema de Controle de Atendimentos para Petshop

Este é um sistema RESTful desenvolvido com **Spring Boot** para gerenciar atendimentos, cadastro de pets e clientes. O sistema possui autenticação JWT e autorização baseada em papéis (**Admin** e **Cliente**).

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **Banco de Dados Relacional (PostgreSQL)**
- **Swagger para documentação da API**

## Funcionalidades

- Cadastro de Clientes e Pets
- Gerenciamento de Endereços e Contatos
- Registro de Atendimentos
- Autenticação e Autorização via JWT
- Controle de Acesso por Perfis (Admin e Cliente)

## Como Executar o Projeto  

### **1️⃣ Configurar o Banco de Dados**
Certifique-se de ter um banco de dados PostgreSQL rodando e configure as credenciais no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/petshopdb
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.hikari.maximum-pool-size=10
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
### 2️⃣ Clonar o Repositório
git clone [https://github.com/Januario86/api-pet.git](https://github.com/Januario86/api-pet.git)

### 3️⃣ Executar a Aplicação
Acessar a API
Após iniciar o projeto, a API estará disponível em http://localhost:8080.

Para visualizar a documentação da API:

Swagger: http://localhost:8080/swagger-ui.html

Para acessar endpoints protegidos, faça login em /auth/login e use o token no header Authorization:
Authorization: Bearer SEU_TOKEN_JWT
