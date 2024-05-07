CREATE TABLE pagamento (
    id bigint not null auto_increment,
    formaPagamento VARCHAR(100) not null,
    status boolean not null,

    primary key(id)
);