CREATE DATABASE adress;

CREATE TABLE IF NOT EXISTS adress (
  id bigserial AUTO_INCREMENT PRIMARY KEY NOT NULL,
  streetname VARCHAR(255) NOT NULL,
  numberadress INT NOT NULL,
  complement VARCHAR(255),
  neighbourhood VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  stateadress VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  zipcode VARCHAR(255) NOT NULL,
  latitude VARCHAR(255),
  longitude VARCHAR(255)
);
