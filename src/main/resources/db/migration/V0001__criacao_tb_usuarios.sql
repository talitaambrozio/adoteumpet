
create table tb_users(
    user_id VARCHAR(36) primary key,
    name varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(120) not null,
    cell_phone_number varchar(13) not null,
    cpf varchar(11) not null unique
);
