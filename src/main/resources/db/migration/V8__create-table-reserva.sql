CREATE TABLE reserva (
    id bigint not null auto_increment,
    data_inicio DATE not null,
    data_fim DATE not null,
    status boolean not null,
    id_quarto bigint,
    id_hospede bigint,

    primary key(id),
    FOREIGN KEY(id_quarto) REFERENCES quarto(id),
    FOREIGN KEY(id_hospede) REFERENCES hospede(id)
);
