-- Migration: create_fornecedor_table
-- Created at Fri Aug  7 10:16:32     2026

CREATE TABLE clientes(
    -- BaseEntity
    id BIGSERIAL PRIMARY KEY,
    uuid UUID NOT NULL,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP,

    parceiro_id BIGINT NOT NULL,

    CONSTRAINT  uk_clientes_uuid UNIQUE (uuid),
    CONSTRAINT uk_clientes_parceiro_id UNIQUE (parceiro_id),
    CONSTRAINT fk_clientes_parceiro FOREIGN KEY (parceiro_id)
    REFERENCES parceiros (id)
)