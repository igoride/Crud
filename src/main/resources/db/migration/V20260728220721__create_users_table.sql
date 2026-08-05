-- Migration: create users table
-- Created at Tue Jul 28 22:07:21     2026

CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(16),
    cargo VARCHAR(20) NOT NULL,
    empresa_id BIGINT NOT NULL,
    role VARCHAR(255)
)