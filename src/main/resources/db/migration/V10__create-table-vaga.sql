CREATE TABLE vaga (
    id bigint not null auto_increment,
    status boolean not null,
    id_carro bigint,

    primary key(id),
    FOREIGN KEY(id_carro) REFERENCES carro(id)
);