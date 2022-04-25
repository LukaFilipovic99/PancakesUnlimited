
CREATE TABLE if not exists `pancakes` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `pancakes_with_ingredients`(
    `pancake_id` bigint NOT NULL,
    `ingredient_id` bigint NOT NULL,
    PRIMARY KEY (`pancake_id`,`ingredient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;