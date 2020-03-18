DROP TABLE IF EXISTS city;

CREATE TABLE city (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL
);

INSERT INTO city (name, state) VALUES
  ('Florianópolis', 'SC');