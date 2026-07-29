-- Migration: create users table
-- Created at Tue Jul 28 22:07:21     2026

CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    ativo BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255)
)