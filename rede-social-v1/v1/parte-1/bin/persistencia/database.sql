
CREATE TABLE usuario (
	id SERIAL,
	apelido VARCHAR(16),
	email VARCHAR(64),
	hash_senha VARCHAR(256),
	nome_completo VARCHAR(64),
	biografia VARCHAR(256),
	PRIMARY KEY (id)
);

CREATE TABLE mensagem (
	id SERIAL,
	id_conversa INTEGER,
  id_autor INTEGER,
	texto VARCHAR(256),
	data_envio DATE,
	visualizado BOOLEAN,
	recebido BOOLEAN,
	PRIMARY KEY (id),
  FOREIGN KEY (id_autor REFERENCES usuario),
	FOREIGN KEY (id_conversa) REFERENCES conversa
);

CREATE TABLE post (
	id SERIAL,
	id_autor INTEGER,
	foto OID,
	legenda VARCHAR(64),
	data_publicacao DATE,
	PRIMARY KEY (id),
	FOREIGN KEY (id_autor) REFERENCES usuario
);

CREATE TABLE comentario (
	id SERIAL,
	id_post INTEGER,
	id_autor INTEGER,
	texto VARCHAR(256),
	PRIMARY KEY (id),
	FOREIGN KEY (id_post) REFERENCES post,
	FOREIGN KEY (id_autor) REFERENCES usuario
);

CREATE TABLE conversa (
  id SERIAL,
  id_usuario_1 INTEGER,
  id_usuario_2 INTEGER,
  PRIMARY KEY (id),
	FOREIGN KEY (id_usuario_1) REFERENCES usuario,
	FOREIGN KEY (id_usuario_2) REFERENCES usuario,
  UNIQUE (id_usuario_1, id_usuario_2),
  CHECK (id_usuario_1 < id_usuario_2)
);

CREATE TABLE seguido_seguidor (
	id SERIAL,
	id_seguido INTEGER,
	id_seguidor INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (id_seguido) REFERENCES usuario,
	FOREIGN KEY (id_seguidor) REFERENCES usuario
);

CREATE TABLE post_favorito (
	id_usuario INTEGER,
	id_post INTEGER,
	PRIMARY KEY (id_usuario, id_post),
	FOREIGN KEY (id_usuario) REFERENCES usuario,
	FOREIGN KEY (id_post) REFERENCES post
);

CREATE TABLE comentario_favorito (
	id_usuario INTEGER,
	id_comentario INTEGER,
  PRIMARY KEY (id_usuario, id_comentario),
	FOREIGN KEY (id_usuario) REFERENCES usuario,
	FOREIGN KEY (id_comentario) REFERENCES comentario
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

CREATE TABLE conversa_2 (
  id_u1 INTEGER,
  id_u2 INTEGER CHECK (id_u2 > id_u1),
  PRIMARY KEY (id_u1, id_u2),
  FOREIGN KEY (id_u1) REFERENCES usuario,
  FOREIGN KEY (id_u2) REFERENCES usuario
);

CREATE TABLE conversa_2 (
  id INTEGER,
  id_u1 INTEGER,
  id_u2 INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (id_u1) REFERENCES usuario,
  FOREIGN KEY (id_u2) REFERENCES usuario,
  UNIQUE (least(id_u1, id_u2), greatest(id_u1, id_u2))
);