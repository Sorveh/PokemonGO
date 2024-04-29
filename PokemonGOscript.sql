-- Create user for local access.
CREATE USER 'usrpokemon'@'localhost' IDENTIFIED BY 'pokemon';

-- Create database.
CREATE DATABASE pokemongo
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

-- Grant permissions.
GRANT SELECT, INSERT, UPDATE, DELETE ON pokemongo.* TO 'usrpokemon'@'localhost';

-- Use database.
USE pokemongo;

-- Create tables
CREATE TABLE `entrenadors` (
`id` INT(4) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`password` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`)
)

CREATE TABLE `pokemons` (
`id` INT(4) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`type` VARCHAR(40) NOT NULL,
PRIMARY KEY (`id`)
)

-- Data insertion.
INSERT INTO `entrenadors` (`id`, `name`, `password`) 
VALUES
(1, 'Entrenador 1', 'entrenador');

INSERT INTO `pokemons` (`id`, `name`, `type`) 
VALUES
(1, 'Pokemon 1', 'pokemon');