DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
     `id` INT NOT NULL AUTO_INCREMENT,
     `email` VARCHAR(200) NOT NULL,
     `name` VARCHAR(200) NOT NULL,
     `password` VARCHAR(100) NOT NULL,
     PRIMARY KEY(id)
);