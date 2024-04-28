CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    nome varchar(256) NOT NULL,
    documento varchar(14),
    email varchar(256),
    senha varchar(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);
CREATE TABLE IF NOT EXISTS documentos(
    id SERIAL PRIMARY KEY,
    documentos TEXT[],
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    id_user SERIAL NOT NULL,

    FOREIGN KEY (id_user) REFERENCES users(id)
);
CREATE TABLE IF NOT EXISTS endereco(
    id SERIAL PRIMARY KEY,
    cep varchar(9) NOT NULL,
    pais varchar(256) NOT NULL,
    UF varchar(2) NOT NULL,
    cidade varchar(256) NOT NULL,
    bairro varchar(256) NOT NULL,
    rua varchar(256) NOT NULL,
    numero_casa varchar(256) NOT NULL,
    id_user SERIAL NOT NULL,

    FOREIGN KEY (id_user) REFERENCES users(id)
);
CREATE TABLE IF NOT EXISTS protocolos(
    id SERIAL PRIMARY KEY,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    id_user SERIAL NOT NULL,
    id_user_editor SERIAL,

    FOREIGN KEY (id_user) REFERENCES users(id) 
);