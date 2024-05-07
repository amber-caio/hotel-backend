CREATE TABLE restaurante (
    id bigint not null auto_increment,
    turno VARCHAR(100) not null,
    id_cardapio bigint,

    primary key(id),
    FOREIGN KEY(id_cardapio) REFERENCES cardapio(id)
);