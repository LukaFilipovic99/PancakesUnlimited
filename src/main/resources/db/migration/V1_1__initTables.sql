CREATE TABLE if not exists ingredients(
    id long primary key,
    name varchar(255) not null ,
    price double not null
);

CREATE TABLE if not exists categories(
    id long primary key,
    name varchar(255) not null
);

