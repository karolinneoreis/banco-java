# 🏦 Banco Java - Sistema de Gerenciamento Bancário

Projeto desenvolvido em Java com foco em Programação Orientada a Objetos (POO), simulando um sistema bancário completo via terminal.

---

## 🚀 Funcionalidades

- Criar conta bancária
- Login com senha
- Depósito em conta
- Saque com validação de saldo
- Transferência entre contas
- Extrato de movimentações
- Logout de usuário

---

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Listas (ArrayList)
- Separação de camadas (Model / Service / Main)
- Lógica de negócio
- Controle de autenticação simples

---

## 📁 Estrutura do projeto
src/
├── main/
│ └── Main.java
├── model/
│ └── Conta.java
├── service/
│ └── BancoService.java


---

## ▶️ Como executar o projeto

### 1. Compilar

```bash
javac src/model/*.java src/service/*.java src/main/Main.java
2. Executar
java -cp src main.Main
💡 Objetivo do projeto

Este projeto foi desenvolvido para praticar conceitos fundamentais de Java e simular um sistema real de banco, servindo como base para evolução futura para sistemas com banco de dados e API (Spring Boot).

📌 Próximos passos (melhorias futuras)
Persistência de dados em arquivo ou banco de dados
Integração com Spring Boot (API REST)
Interface gráfica ou web
Segurança com criptografia de senha

ATT, Ana Caroline Reis
