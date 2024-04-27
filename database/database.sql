CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    nome varchar(256) NOT NULL,
    documento varchar(14),
    email varchar(256),
    senha varchar(256) NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NOT NULL
    role SMALLINT NOT NULL
);
CREATE TABLE IF NOT EXISTS documentos();
CREATE TABLE IF NOT EXISTS endereco();
CREATE TABLE IF NOT EXISTS protocolos();