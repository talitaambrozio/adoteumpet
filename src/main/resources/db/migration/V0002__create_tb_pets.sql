CREATE TABLE tb_pets (
    pet_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    race VARCHAR(100) NOT NULL,
    color VARCHAR(120) NOT NULL,
    age INT NOT NULL,
    status_pet BOOLEAN NOT NULL DEFAULT TRUE,
    user_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_users (user_id) ON DELETE CASCADE
);

CREATE TABLE user_pet (
    user_pet_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    pet_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (pet_id) REFERENCES tb_pets (pet_id) ON DELETE CASCADE
);

