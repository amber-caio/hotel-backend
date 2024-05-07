CREATE TABLE quarto (
    id bigint not null auto_increment,
    tipo VARCHAR(100) not null,
    status boolean not null,
    valor_diaria DOUBLE not null,

    primary key(id)
);