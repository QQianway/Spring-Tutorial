CREATE DATABASE IF NOT EXISTS donut;
USE donut;

DROP TABLE IF EXISTS `donut`.`donut`;
CREATE TABLE `donut`.`donut` (
  `id` VARCHAR(5) NOT NULL,
  `name` VARCHAR(100) NULL,
  `price` DOUBLE(5,2) NOT NULL,
  `store` INT(5) NULL,
  PRIMARY KEY (`id`));
Insert into Donut values("1","Donut1",1.00,20)
Insert into Donut values("2","Donut2",2.00,20)
Insert into Donut values("3","Donut3",3.00,20)
Insert into Donut values("4","Donut4",4.00,20)