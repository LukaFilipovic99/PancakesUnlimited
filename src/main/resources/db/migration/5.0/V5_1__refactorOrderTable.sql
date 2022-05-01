CREATE table if not exists orders(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    ordered_at TIME NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE orders MODIFY COLUMN ordered_at DATETIME;