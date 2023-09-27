CREATE TABLE tb_pets(
    pet_id BINARY(36) primary key,
    name varchar(100) not null,
    race varchar(100) not null,
    color varchar(120) not null,
    age int(2) not null,
    user_id BINARY(36) not null,


    FOREIGN KEY (user_id) REFERENCES tb_users (user_id)
);
