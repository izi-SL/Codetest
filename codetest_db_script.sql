CREATE DATABASE codetest;
USE codetest;
CREATE TABLE 'customer' (
	'id' INT(10) NULL AUTO_INCREMENT,
	'name' VARCHAR(50) NULL DEFAULT '0',
	'email' VARCHAR(50) NULL DEFAULT '0',
	'department' VARCHAR(50) NULL DEFAULT '0',
	PRIMARY KEY ('id')
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE 'log' (
	'id' INT(10) NULL AUTO_INCREMENT,
	'dated' DATETIME NULL DEFAULT '0',
	'logger' VARCHAR(50) NULL DEFAULT '0',
	'level' VARCHAR(50) NULL DEFAULT '0',
	'message' VARCHAR(100) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;