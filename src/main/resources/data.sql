DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS customer;

CREATE TABLE city (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL UNIQUE,
  state VARCHAR(250) NOT NULL
);

INSERT INTO city (name, state) VALUES
  ('Florianópolis', 'SC');

CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL UNIQUE,
  sex INT(2) NOT NULL,
  birthdate TIMESTAMP NOT NULL,
  age int(3) NOT NULL,
  city VARCHAR(250) NOT NULL
);

INSERT INTO customer (name, sex, birthdate, age, city) VALUES
  ('Tiago Filipe', 0, '1993-07-26 00:00:00', 26, 'Florianópolis');