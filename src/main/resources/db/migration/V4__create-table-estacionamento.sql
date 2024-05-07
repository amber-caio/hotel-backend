CREATE TABLE estacionamento (
    id bigint not null auto_increment,
    qtd_vagas_disponiveis INTEGER not null,
    qd_vagas_ocupadas INTEGER not null,

    PRIMARY KEY(id)
);