
# 🐶 Agenda Pet API

Sistema robusto de gerenciamento para clínicas veterinárias, desenvolvido com as tecnologias mais recentes do ecossistema Java para garantir segurança e escalabilidade.

## 🚀 Diferenciais Técnicos
*   **Java 25 (OpenJDK):** Utilização da versão mais recente da linguagem para performance otimizada.
*   **Spring Boot 4.0.3 & Spring Security 7.x:** Implementação de segurança total (`anyRequest().authenticated()`) com autenticação via Basic Auth.
*   **Criptografia BCrypt:** Proteção de senhas no banco de dados utilizando algoritmos de hash de alta segurança.
*   **Domain-Driven Design (DDD) e Clean Architecture:** Uso de Value Objects para encapsular lógicas de validação de CPF e Telefone, garantindo que nenhum dado inválido circule pelo sistema e mantendo um baixo acoplamento.

## 🛠️ Tecnologias e Dependências
*   **Java 25**
*   **Spring Boot 4.0.3**
*   **Spring Data JPA** (Persistência)
*   **MySQL Connector 9.6.0** (Banco de dados)
*   **Jakarta Validation** (Validação de Beans)
*   **Lombok** (Redução de boilerplate)

## 🗄️ Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina as seguintes ferramentas:
*   [Java 25](https://jdk.java.net/25/)
*   [Maven](https://maven.apache.org/)
*   [MySQL](https://www.mysql.com/) rodando localmente (porta `3306`)

## ⚙️ Configuração e Execução Local

### 1. Configuração do Banco de Dados
Crie um banco de dados no MySQL chamado `agendapet`. As tabelas serão geradas automaticamente pelo Hibernate ao iniciar a aplicação.
```sql
CREATE DATABASE agendapet;
2. Rodando o Projeto
Clone o repositório e execute a aplicação utilizando o Maven:
git clone https://github.com/emanuelleda/AgendaPet.git
cd AgendaPet
./mvnw spring-boot:run
🔐 Acesso e Testes da API
Por padrão, a API está configurada com o permitAll desativado para garantir a proteção total dos dados em todos os endpoints.
Credenciais de teste (criadas automaticamente no log ao iniciar a aplicação):
Usuário: recrutador
Senha: pet123
Exemplo de Requisição (via cURL)
curl -u recrutador:pet123 http://localhost:8080/funcionarios
📚 Documentação da API (Swagger/OpenAPI)
(Opcional: Caso adicione a dependência do Springdoc OpenAPI ao projeto) Após iniciar a aplicação, a documentação interativa detalhando os fluxos e retornos de todos os endpoints estará disponível acessando: 👉 http://localhost:8080/swagger-ui.html

--------------------------------------------------------------------------------
Desenvolvido por emanuelleda.
