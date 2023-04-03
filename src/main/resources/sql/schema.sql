DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `users_collect`;
DROP TABLE IF EXISTS `place`;

CREATE TABLE `users` (
     `id` INT NOT NULL AUTO_INCREMENT,
     `email` VARCHAR(200) NOT NULL,
     `name` VARCHAR(200) NOT NULL,
     `password` VARCHAR(100) NOT NULL,
     PRIMARY KEY(id)
);

CREATE TABLE `users_collect` (
     `id` INT NOT NULL AUTO_INCREMENT,
     `user_id` INT NOT NULL,
     `place_id` VARCHAR(200) NOT NULL,
     PRIMARY KEY(id)
);

CREATE TABLE `place` (
    `id` VARCHAR(50) NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    `url` VARCHAR(200) NOT NULL,
    `website` VARCHAR(200),
    `address` VARCHAR(200)
);