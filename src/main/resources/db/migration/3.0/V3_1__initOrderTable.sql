CREATE table if not exists orders(
    id bigint primary key auto_increment,
    description varchar(255),
    ordered_at time NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE if not exists pancakes (
    id bigint primary key AUTO_INCREMENT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE pancakes ADD order_id bigint;

