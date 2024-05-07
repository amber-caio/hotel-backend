ALTER TABLE carro ADD COLUMN id_hospede bigint,
ADD FOREIGN KEY (id_hospede) REFERENCES hospede(id);