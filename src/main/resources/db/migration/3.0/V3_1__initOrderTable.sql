CREATE table if not exists orders(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    ordered_at TIME NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS pancakes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE pancakes ADD order_id bigint;

