
create table tb_users(
    userid VARCHAR(36) primary key,
    name varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(120) not null,
    cell_phone_number varchar not null,
    cpf varchar(13) not null
);
