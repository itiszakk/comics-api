CREATE SCHEMA IF NOT EXISTS comics;
SET search_path TO comics;

CREATE TABLE IF NOT EXISTS character_image (
    id SERIAL PRIMARY KEY,
    url TEXT
);

CREATE TABLE IF NOT EXISTS character_info (
    id SERIAL PRIMARY KEY,
    description TEXT
);

CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    character_image_id INTEGER REFERENCES character_image(id),
    character_info_id INTEGER REFERENCES character_info(id)
);