CREATE TABLE IF NOT EXISTS tb_user(
    id SERIAL PRIMARY KEY,
    nome varchar(256) NOT NULL,
    documento varchar(14),
	sexo varchar(254),
	data_nasc Date,
    email varchar(256),
    senha varchar(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);
CREATE TABLE IF NOT EXISTS tb_admin(
    id SERIAL PRIMARY KEY,
    nome varchar(256) NOT NULL,
    documento varchar(14),
	email varchar(256),
    senha varchar(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_login(
    id SERIAL PRIMARY KEY,
    nome varchar(256) NOT NULL,
    documento varchar(14),
    senha varchar(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
	id_user SERIAL,
	id_admin SERIAL,
	
	FOREIGN KEY(id_user) REFERENCES tb_user(id),
	FOREIGN KEY(id_admin) REFERENCES tb_admin(id)
);

CREATE TABLE IF NOT EXISTS tb_subject(
	id SERIAL PRIMARY KEY,
	subject VARCHAR(256),
	id_user SERIAL NOT NULL,
	id_inmost_visit SERIAL NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	
	FOREIGN KEY(id_user) REFERENCES tb_user(id)
	FOREIGN KEY(id_inmost_visit) REFERENCES tb_subject_inmost_visit(id)
);

CREATE TABLE IF NOT EXISTS tb_subject_inmost_visit(
	id SERIAL PRIMARY KEY,
	cumplice BOOLEAN NOT NULL,
	vitima BOOLEAN NOT NULL,
	gravida BOOLEAN NOT NULL,
	tempo_gravidez smallint,
	id_user SERIAL NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	FOREIGN KEY(id_user) REFERENCES tb_user(id);
);

CREATE TABLE IF NOT EXISTS tb_documents(
    id SERIAL PRIMARY KEY,
    documentos TEXT[],
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    id_user SERIAL NOT NULL,

    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);
CREATE TABLE IF NOT EXISTS tb_address(
    id SERIAL PRIMARY KEY,
    cep varchar(9) NOT NULL,
    pais varchar(256) NOT NULL,
    UF varchar(2) NOT NULL,
    cidade varchar(256) NOT NULL,
    bairro varchar(256) NOT NULL,
    rua varchar(256) NOT NULL,
    numero_casa varchar(256) NOT NULL,
    id_user SERIAL NOT NULL,

    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);
CREATE TABLE IF NOT EXISTS protocolos(
    id SERIAL PRIMARY KEY,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    id_user SERIAL NOT NULL,
    id_user_editor SERIAL,

    FOREIGN KEY (id_user) REFERENCES tb_user(id) 
	FOREIGN KEY (id_user_editor) REFERENCES tb_admin(id) 
);


SELECT * from tb_user
INSERT INTO tb_user (nome, documento, email, sexo, data_nasc, senha, role, created_at, updated_at)
VALUES ('João Silva', '123.456.789-00', 'joao@example.com', 'Masculino', '2001-10-05', 'senha123', 0, NOW(), NOW()),
       ('Maria Souza', '987.654.321-00', 'maria@example.com','Feminino', '2003-12-20', 'senha456', 0, NOW(), NOW()),
       ('Maria Souza', '987.654.321-00', 'maria@example.com', 'Feminino', '2003-12-20', 'senha456', 0, NOW(), NOW());

SELECT * FROM tb_user
INSERT INTO tb_address (cep, pais, UF, cidade, bairro, rua, numero_casa, id_user)
VALUES ('12345-678', 'Brasil', 'PR', 'Foz do Iguaçu', 'Centro', 'Rua A', '123', 1),
       ('54321-876', 'Brasil', 'PR', 'Foz do Iguaçu', 'Morumbi', 'Av. B', '456', 2),
       ('54321-876', 'Brasil', 'PR', 'Foz do Iguaçu', 'Morumbi', 'Av. C', '236', 3);


CREATE OR REPLACE FUNCTION include_value_protocol()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO tb_protocols(created_at, updated_at, id_user)
	VALUES(NOW(), NOW(), NEW.id_user);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_protocols_value
AFTER INSERT
ON tb_protocols
FOR EACH ROW
WHEN (pg_trigger_depth() < 1)
EXECUTE FUNCTION include_value_protocol();

INSERT INTO tb_protocols(created_at, updated_at, id_user)
	VALUES(NOW(), NOW(), 1);
	
	SELECT * FROM tb_protocols

DROP TRIGGER insert_protocols_value ON tb_protocols;
DROP FUNCTION include_value_protocol;