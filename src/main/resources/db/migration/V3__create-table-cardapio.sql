CREATE TABLE cardapio (
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    entrada VARCHAR(100) not null,
    pratoPrincipal VARCHAR(100) not null,
    sobremesa VARCHAR(100) not null,
    ativo boolean not null,

    primary key(id)
);
