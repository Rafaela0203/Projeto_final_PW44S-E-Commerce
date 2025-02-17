# Projeto Final PW44S: E-Commerce

Este projeto é composto por duas partes principais:

1. **Servidor (Back-end)**: Desenvolvido em Java utilizando o framework Spring Boot.
2. **Cliente (Front-end)**: Desenvolvido em React com TypeScript e Vite.

## Funcionalidades

- Catálogo de produtos
- Página de detalhes de cada produto
- Carrinho de compras
- Processamento de pedidos

## Tecnologias Utilizadas

- **Back-end**: Java, Spring Boot
- **Front-end**: React, TypeScript, Vite

## Como Executar o Projeto

### Pré-requisitos

- Java 11 ou superior instalado
- Node.js e npm instalados

### Passos para Executar

1. **Clone os Repositórios**

   ```bash
   git clone https://github.com/Rafaela0203/Projeto_final_PW44S-E-Commerce.git
   git clone https://github.com/Rafaela0203/DeluxClient-PW44S.git
   ```

2. **Back-end**

   - Navegue até o diretório do servidor:
     ```bash
     cd Projeto_final_PW44S-E-Commerce
     ```
   - Compile e execute a aplicação Spring Boot:
     ```bash
     ./mvnw spring-boot:run
     ```
   - A API estará disponível em `http://localhost:8080`.

3. **Front-end**

   - Navegue até o diretório do cliente:
     ```bash
     cd DeluxClient-PW44S
     ```
   - Instale as dependências:
     ```bash
     npm install
     ```
   - Inicie a aplicação React:
     ```bash
     npm run dev
     ```
   - A aplicação estará disponível em `http://localhost:5173`.

## Estrutura do Projeto

- **Back-end**:
  - `src/`: Contém o código-fonte da aplicação Spring Boot.
  - `pom.xml`: Arquivo de configuração do Maven.

- **Front-end**:
  - `src/`: Contém o código-fonte da aplicação React.
  - `package.json`: Arquivo de configuração do npm.

## Contribuidores

- [Rafaela0203](https://github.com/Rafaela0203)
- [Dante-doo](https://github.com/Dante-doo)
