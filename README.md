# Projeto JDBC com Docker e PostgreSQL

Este projeto foi feito para demonstrar como um aplicativo Java pode se conectar a um banco PostgreSQL usando JDBC.

A ideia principal é automatizar tudo com Docker e deixar o Java se comunicar com o banco para inserir e buscar dados.

---

## Dockerfile + init.sql

O banco de dados PostgreSQL é criado a partir de um `Dockerfile` personalizado.

Esse `Dockerfile` copia o script `init.sql`, que é executado automaticamente ao iniciar o container. Isso garante que a tabela necessária já esteja pronta.

---

## Como executar

### 1. Suba o banco PostgreSQL

Abra o terminal na pasta do projeto e rode:

```bash
docker build -t postgres-com-tabela .
docker run -d --name meu-postgres -p 5432:5432 postgres-com-tabela
```

### 2. Executando o código java via .jar

Abra o terminal na pasta do projeto e rode:

```bash
.\run.bat
```