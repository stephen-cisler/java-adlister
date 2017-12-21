CREATE DATABASE IF NOT EXISTS ad_lister_datab;

USE ad_lister_datab;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(100),
  email    VARCHAR(150),
  password VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id     INT UNSIGNED NOT NULL,
  title       VARCHAR(255),
  description TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

TRUNCATE ads;
TRUNCATE users;

INSERT INTO users (username, email, password) VALUES ('steve', 'email', 'password'),
  ('esteban', 'email', 'password');

INSERT INTO ads (user_id, title, description)
VALUES (1, 'playstation for sale', 'This is a slightly used playstation'),
  (1, 'Super Nintendo', 'Get your game on with this old-school classic'),
  (2, 'Junior Java Developer Position',
   'Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript'),
  (2, 'JavaScript Developer needed', 'Must have strong Java skills');

SELECT *
FROM ads;

