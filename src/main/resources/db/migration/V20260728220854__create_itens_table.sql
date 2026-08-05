-- Migration: create itens table
-- Created at Tue Jul 28 22:08:54     2026

CREATE TABLE itens (
    id BIGSERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
)