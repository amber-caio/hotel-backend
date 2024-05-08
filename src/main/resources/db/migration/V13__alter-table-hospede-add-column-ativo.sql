ALTER TABLE hospede ADD COLUMN ativo tinyint;
UPDATE hospede SET ativo =1;