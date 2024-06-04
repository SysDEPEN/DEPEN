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

	FOREIGN KEY(id_user) REFERENCES tb_user(id),
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
	FOREIGN KEY(id_user) REFERENCES tb_user(id)
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

    FOREIGN KEY (id_user) REFERENCES tb_user(id),
	FOREIGN KEY (id_user_editor) REFERENCES tb_admin(id)
);
