-- Migration: create_parceiro_table
-- Created at Fri Aug  7 09:54:41     2026

CREATE TABLE parceiros (
-- BaseEntity
    id BIGSERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP,

    nome VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    tipo_pessoa VARCHAR(30) NOT NULL,

    CONSTRAINT  uk_clientes_uuid UNIQUE (uuid),
    CONSTRAINT uk_clientes_cpf_cnpj UNIQUE (cpf_cnpj)
)