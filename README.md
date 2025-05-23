# 🛠️ Projeto de Gestão de Estoque — Programação Orientada a Objetos (POO)

Este projeto foi desenvolvido como parte da disciplina de Programação Orientada a Objetos (POO). Seu objetivo é simular um sistema completo de gestão de estoque, com funcionalidades que englobam desde o controle de produtos até registros de vendas, clientes e funcionários.

---

## ⚙️ Tecnologias Utilizadas

- ✅ Java 21
- ✅ Spring Boot
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ Banco de Dados H2 (memória)
- ✅ MySQL com phpMyAdmin (em desenvolvimento/produção)
- ✅ Maven (gerenciador de dependências)

---

## 📦 Funcionalidades Implementadas

- Cadastro e gerenciamento de:
  - 🧑‍💼 Funcionários
  - 🧍 Clientes
  - 📦 Produtos (diversos tipos)
  - 🏪 Estoque
  - 💸 Formas de Pagamento (PIX, Cartão, Dinheiro etc.)
  - 🧾 Registros de Vendas e Aluguéis

- Relacionamentos entre entidades:
  - Funcionário realiza uma venda para um cliente
  - Produtos são atualizados no estoque (quantidade e preço)
  - Clientes acumulam número de pedidos realizados

- Persistência de dados com JPA e banco relacional
- Endpoints REST para acesso e manipulação via JSON
- Integração com H2 Database para testes rápidos
- Integração com phpMyAdmin e MySQL para persistência real

---


