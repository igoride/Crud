-- Migration: create clientes table
-- Created at Tue Jul 28 22:08:46     2026

CREATE TABLE clientes(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(16),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255),
    tipo_pessoa VARCHAR(255) NOT NULL
)