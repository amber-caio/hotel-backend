CREATE TABLE ticket (
    id bigint not null auto_increment,
    data_hora DATE not null,
    total DOUBLE not null,
    status BOOLEAN not null,
    id_hospede bigint,
    id_vaga bigint,
    id_carro bigint,

    primary key(id),
    FOREIGN KEY(id_hospede) REFERENCES hospede(id),
    FOREIGN KEY(id_vaga) REFERENCES vaga(id),
    FOREIGN KEY(id_carro) REFERENCES carro(id)
);