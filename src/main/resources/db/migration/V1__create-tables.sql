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
);

CREATE TABLE cardapio (
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    entrada VARCHAR(100) not null,
    prato VARCHAR(100) not null,
    sobremesa VARCHAR(100) not null,
    ativo TINYINT not null,

    PRIMARY KEY(id)
);

CREATE TABLE restaurante(
    id bigint not null auto_increment,
    turno VARCHAR(100) NOT NULL,
    fk_cardapio bigint,

    PRIMARY KEY(id),
    FOREIGN KEY(fk_cardapio) REFERENCES cardapio(id)

);

CREATE TABLE funcionario(
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    cpf VARCHAR(15) not null,
    data_admissao VARCHAR(100) not null,
    ativo TINYINT not null,

    PRIMARY KEY(id)
);

CREATE TABLE quarto(
    id bigint not null auto_increment,
    tipo VARCHAR(20) not null,
    status TINYINT not null,
    valor_diaria DOUBLE not null,

    PRIMARY KEY(id)
);

CREATE TABLE reserva(
    id bigint not null auto_increment,
    data_inicio VARCHAR(100) not null,
    data_fim VARCHAR(100) not null,
    status TINYINT not null,
    fk_quarto bigint,
    fk_hospede bigint,

    PRIMARY KEY(id),
    FOREIGN KEY(fk_quarto) REFERENCES quarto(id),
    FOREIGN KEY(fk_hospede) REFERENCES hospede(id)
);

CREATE TABLE user(
    id bigint not null auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    name varchar(100) not null,
    role varchar(20) not null,


    primary key(id)
);

