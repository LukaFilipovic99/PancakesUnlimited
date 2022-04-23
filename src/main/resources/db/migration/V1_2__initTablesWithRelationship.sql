CREATE TABLE if not exists `categories` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `ingredients` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `price` double NOT NULL,
    `category_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK44j0v4g89hhdoe09s8fp7kos6` (`category_id`),
    CONSTRAINT `FK44j0v4g89hhdoe09s8fp7kos6` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO categories (name) VALUES ('baza');
INSERT INTO categories (name) VALUES ('nadjev');
INSERT INTO categories (name) VALUES ('preljev');
INSERT INTO categories (name) VALUES ('voće');
