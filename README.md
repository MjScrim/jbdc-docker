# Projeto JDBC com Docker e PostgreSQL

Este projeto foi feito para demonstrar como um aplicativo Java pode se conectar a um banco PostgreSQL usando JDBC.

A ideia principal é automatizar tudo com Docker e deixar o Java se comunicar com o banco para inserir e buscar dados.

---

## docker-compose + init.sql

O banco de dados PostgreSQL é criado a partir de um `docker-compose.yml` personalizado.

Esse `docker-compose.yml` copia o script `init.sql`, que é executado automaticamente ao iniciar o container. Isso garante que a tabela necessária já esteja pronta.

---

## Como executar

### 1. Suba o banco PostgreSQL

Abra o terminal na pasta do projeto e rode:

```bash
docker-copmpose up --build
```

### 2. Executando o código java separadamente fora do Docker via .jar

Abra o terminal na pasta do projeto e rode:

```bash
.\run.bat
```
