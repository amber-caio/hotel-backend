CREATE TABLE hospede (
    id bigint not null auto_increment,
    nome VARCHAR(100) not null,
    cpf VARCHAR(100) not null,
    idade INTEGER not null,

    PRIMARY KEY(id)
)