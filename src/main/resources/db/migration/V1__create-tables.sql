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

CREATE TABLE vaga(
    id bigint not null auto_increment,
    status TINYINT not null,

    fk_carro bigint,

    FOREIGN KEY (fk_carro) REFERENCES carro(id),
    PRIMARY KEY(id)
);

CREATE TABLE ticket(
    id bigint not null auto_increment,
    data_hora VARCHAR(255) not null,
    total DOUBLE not null,
    status TINYINT not null,

    fk_hospede bigint,
    fk_carro bigint,
    fk_vaga bigint,

    FOREIGN KEY (fk_hospede) REFERENCES hospede(id),
    FOREIGN KEY (fk_carro) REFERENCES carro(id),
    FOREIGN KEY (fk_vaga) REFERENCES vaga(id),

    PRIMARY KEY(id)
)


