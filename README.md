# 🐶 Agenda Pet API

Sistema robusto de gerenciamento para clínicas veterinárias, desenvolvido com as tecnologias mais recentes do ecossistema Java para garantir segurança e escalabilidade.

## 🚀 Diferenciais Técnicos
* **Java 25 (OpenJDK):** Utilização da versão mais recente da linguagem para performance otimizada.
* **Spring Security 7.x:** Implementação de segurança total (`anyRequest().authenticated()`) com autenticação via Basic Auth.
* **Criptografia BCrypt:** Proteção de senhas no banco de dados utilizando algoritmos de hash de alta segurança.
* **Domain-Driven Design (DDD):** Uso de Value Objects para encapsular lógicas de CPF e Telefone, garantindo que nenhum dado inválido entre no sistema.

## 🛠️ Tecnologias e Dependências
* **Spring Boot 4.0.3**
* **Spring Data JPA** (Persistência)
* **MySQL Connector 9.6.0** (Banco de dados)
* **Jakarta Validation** (Validação de Beans)
* **Lombok** (Redução de boilerplate)

## 🔐 Acesso à API
Por padrão, a API está configurada com o `permitAll` desativado para garantir a proteção dos dados.

**Credenciais de teste (criadas automaticamente no log):**
- **Usuário:** `recrutador`
- **Senha:** `pet123`

### Exemplo de Requisição (Postman/Curl):
```bash
curl -u recrutador:pet123 http://localhost:8080/funcionarios
