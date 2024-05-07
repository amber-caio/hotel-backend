CREATE TABLE funcionario (
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    cpf VARCHAR(100) not null,
    data_admissao DATE not null,
    ativo BOOLEAN not null,

    primary key(id)
);