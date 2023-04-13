CREATE DATABASE friends_of_mans;
USE friends_of_mans;

CREATE TABLE animal (
  id INT PRIMARY KEY AUTO_INCREMENT, 
  amount INT, 
  `name` VARCHAR(30) NOT NULL, 
  dateOfBirth DATE, 
  commands SET('GO', 'STOP', 'RUN_AWAY', 'LIE', 'STAND_AP', 'JUMP', 'COME_ON')
);


CREATE TABLE pet LIKE animal;
CREATE TABLE pack_animal LIKE animal;

CREATE TABLE dog LIKE pet;
ALTER TABLE dog
ADD COLUMN height INT;

CREATE TABLE cat LIKE pet;
ALTER TABLE cat
ADD COLUMN coat_lenght DOUBLE;

CREATE TABLE hamster LIKE pet;
ALTER TABLE hamster
ADD COLUMN color VARCHAR(10);

CREATE TABLE horse LIKE pack_animal;
ALTER TABLE horse
ADD COLUMN presence_of_pattern VARCHAR(5);

CREATE TABLE camel LIKE pack_animal;
ALTER TABLE camel
ADD COLUMN amount_of_humps INT;

CREATE TABLE donkey LIKE pack_animal;
ALTER TABLE donkey
ADD COLUMN weight INT;

INSERT INTO dog (amount, `name`, dateOfBirth, commands, height)
VALUES
	(4, 'chihuahua', '2015-07-02', 'GO,STAND_AP,JUMP', 15),
    (3, 'dachhund', '2016-01-10', 'GO,LIE,STAND_AP', 26),
    (2, 'corgi', '2017-04-22', 'RUN_AWAY,STAND_AP,JUMP', 30);
    
INSERT INTO cat (amount, `name`, dateOfBirth, commands, coat_lenght)
VALUES
    (1, 'Siamese', '2019-08-02', 'GO', 3.5),
    (3, 'Persian', '2020-07-13', 'GO,LIE', 15.2),
    (5, 'Bengal', '2022-01-01', 'RUN_AWAY,STAND_AP,JUMP,GO', 4.1),
    (2, 'Russian Blue', '2016-04-12', 'COME_ON,LIE,RUN_AWAY', 3.8);

INSERT INTO hamster (amount, `name`, dateOfBirth, commands, color)
VALUES
	(1, 'Syrian', '2021-07-23', 'GO,STAND_AP,JUMP', 'Brown'),
    (1, 'Dzungarian', '2022-02-11', 'GO,LIE,STAND_AP', 'Grey'),
    (3, 'Chinese', '2023-11-30', 'RUN_AWAY,STAND_AP,JUMP', 'Silver');

INSERT INTO horse (amount, `name`, dateOfBirth, commands, presence_of_pattern)
VALUES
	(2, 'Arabian', '2018-07-23', 'GO,STAND_AP,JUMP', 'no'),
    (3, 'Quarter Horse', '2019-02-11', 'GO,LIE,STAND_AP', 'yes'),
    (1, 'Mustang', '2017-11-30', 'RUN_AWAY,STAND_AP,JUMP', 'no');
    
INSERT INTO camel (amount, `name`, dateOfBirth, commands, amount_of_humps)    
VALUES 
	(1, 'Arabian Camel', '2018-07-23', 'GO,STAND_AP,JUMP', 2),
    (1, 'Bactrian', '2019-02-11', 'GO,LIE,STAND_AP', 1),
    (1, 'Alpaca', '2017-11-30', 'RUN_AWAY,STAND_AP,JUMP', 1);

INSERT INTO donkey (amount, `name`, dateOfBirth, commands, weight)
VALUES
	(2, 'Standard Donkey', '2018-07-23', 'GO,STAND_AP,JUMP', 210),
    (2, 'Mammoth Donkey', '2019-02-11', 'GO,LIE,STAND_AP', 297),
    (1, 'Miniature Donkey', '2017-11-30', 'RUN_AWAY,STAND_AP,JUMP', 180);

DROP TABLE camel;

DROP TABLE young_animals;

CREATE TABLE young_animals AS 
SELECT * FROM (
	SELECT 'dog' AS `table_name`, `name`, amount, dateOfBirth FROM dog
	UNION
	SELECT 'cat' AS `table_name`, `name`, amount, dateOfBirth FROM cat
	UNION
	SELECT 'hamster' AS `table_name`, `name`, amount, dateOfBirth FROM hamster
	UNION
	SELECT 'horse' AS `table_name`, `name`, amount, dateOfBirth FROM horse
	UNION
	SELECT 'donkey' AS `table_name`, `name`, amount, dateOfBirth FROM donkey) yang
WHERE TIMESTAMPDIFF(MONTH, dateOfBirth, NOW()) >= 12
AND TIMESTAMPDIFF(MONTH, dateOfBirth, NOW()) <= 36;

ALTER TABLE young_animals
ADD age VARCHAR(20);


UPDATE young_animals
SET age = CONCAT(
    FLOOR(TIMESTAMPDIFF(MONTH, dateOfBirth, NOW()) / 12), ' г. ',
    MOD(TIMESTAMPDIFF(MONTH, dateOfBirth, NOW()), 12), ' мес.'
);


CREATE TABLE all_animals AS
SELECT * FROM (
	SELECT 'dog' AS `table_name`, amount, `name`, dateOfBirth, commands, height, NULL AS coat_lenght, NULL AS color, NULL AS presence_of_pattern, NULL AS weight
	FROM dog
	UNION ALL
	SELECT 'cat' AS `table_name`, amount, `name`, dateOfBirth, commands, NULL AS height, coat_lenght, NULL AS color, NULL AS presence_of_pattern, NULL AS weight
	FROM cat
	UNION ALL
	SELECT 'hamster' AS `table_name`, amount, `name`, dateOfBirth, commands, NULL AS height, NULL AS coat_lenght, color, NULL AS presence_of_pattern, NULL AS weight
	FROM hamster
	UNION ALL
	SELECT 'horse' AS `table_name`, amount, `name`, dateOfBirth, commands, NULL AS height, NULL AS coat_lenght, NULL AS color, presence_of_pattern, NULL AS weight
	FROM horse
	UNION ALL
	SELECT 'donkey' AS `table_name`, amount, `name`, dateOfBirth, commands, NULL AS height, NULL AS coat_lenght, NULL AS color, NULL AS presence_of_pattern, weight
	FROM donkey) animals
