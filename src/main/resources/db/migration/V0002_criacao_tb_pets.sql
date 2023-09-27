    private String name;
    private String race;
    private String color;
    private int age;
    private User user;

CREATE TABLE tb_pets(
    pet_id BINARY(36),
    name varchar(100) not null,
    race varchar(100) not null,
    color varchar(120) not null,
    age int(2) not null,
    user_id BINARY(36) not null,

    PRIMARY KEY (petId),
    FOREIGN KEY (user_id) REFERENCES tb_users (userId)
);
