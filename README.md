# 🐾 AgendaPet API & Gestão

Sistema de gestão para Pet Shops desenvolvido com **Spring Boot**, focado em agendamentos de serviços, controle de funcionários e gestão de clientes (Donos e Pets).

## 🚀 O que foi implementado hoje?

Hoje o projeto deu um salto de qualidade técnica, saindo de um protótipo em memória para uma aplicação robusta:

- **Migração para MySQL:** Substituição do H2 por um banco de dados relacional persistente.
- **Relacionamentos Complexos:** Implementação de `CascadeType.ALL` entre Dono e Pet (salvando ambos em uma única operação).
- **Tratamento de Dados (VOs):** Uso de *Value Objects* para CPF, Telefone e Email com validações personalizadas.
- **Interface Gráfica:** Criação de um Front-end em HTML5, CSS3 e JS para consumir a API em tempo real.
- **CORS Enabled:** Configuração para permitir que o navegador se comunique com o servidor Java.

---

## 🛠️ Tecnologias

- **Back-end:** Java 25, Spring Boot, Spring Data JPA, Lombok, MySQL Connector.
- **Front-end:** HTML5, CSS3 (Modern UI), JavaScript (Fetch API).
- **Ferramentas:** IntelliJ IDEA, Postman, MySQL Workbench.

---

## 🏗️ Arquitetura do Projeto

O projeto utiliza o padrão de camadas para garantir a manutenção e escalabilidade:

1. **Controller:** Gerencia as rotas REST (`/funcionarios`, `/donos`, `/agendamentos`).
2. **Service:** Contém as regras de negócio e garante a atomicidade das operações com `@Transactional`.
3. **Repository:** Interface de comunicação com o MySQL via Spring Data JPA.
4. **Model/Entity:** Mapeamento das tabelas e relacionamentos (`ManyToOne`, `OneToMany`).



---

## 📋 Como Executar

1. **Configurar o Banco:**
   No arquivo `src/main/resources/application.properties`, configure seu usuário e senha do MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/agenda_pet_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
