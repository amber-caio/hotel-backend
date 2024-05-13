CREATE TABLE hospede (
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    cpf VARCHAR(15) not null,
    idade INTEGER not null,
    ativo TINYINT not null,

    PRIMARY KEY(id)
);


CREATE TABLE carro(
    id bigint not null auto_increment,
    placa VARCHAR(100) not null,
    modelo VARCHAR(100) not null,
    ativo TINYINT not null,

    fk_hospede bigint not null,

    FOREIGN KEY (fk_hospede) REFERENCES hospede(id),

    PRIMARY KEY(id)
);


