DROP DATABASE IF EXISTS weborderdatabase;
CREATE DATABASE weborderdatabase;
use weborderdatabase;
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS instruments (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  weight DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts (
  userid INT NOT NULL,
  instrumentid INT NOT NULL,
  instrumentname VARCHAR(100) NOT NULL,
  number INT NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  weight DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS bills (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  userid INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  weight DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS records (
  billid INT NOT NULL,
  userid INT NOT NULL,
  instrumentid INT NOT NULL,
  instrumentname VARCHAR(100) NOT NULL,
  number INT NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
  instrumentid INT NOT NULL,
  userid INT NOT NULL,
  comment VARCHAR(100) NOT NULL
);

INSERT INTO instruments (name, price, weight) VALUES ('Violin', 500.99, 60);
INSERT INTO instruments (name, price, weight) VALUES ('Piano', 10000, 100);
INSERT INTO instruments (name, price, weight) VALUES ('Guitar', 698, 30);
