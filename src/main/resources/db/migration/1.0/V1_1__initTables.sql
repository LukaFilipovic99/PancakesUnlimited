CREATE TABLE if not exists ingredients(
    id bigint primary key auto_increment,
    name varchar(255) not null ,
    price double not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists categories(
    id bigint primary key auto_increment,
    name varchar(255) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

