CREATE TABLE `t_user` (
                          `id` char(19) COLLATE utf8mb4_general_ci NOT NULL COMMENT ' ',
                          `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci