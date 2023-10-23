CREATE TABLE tb_users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL,
    cell_phone_number VARCHAR(13) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE
);
