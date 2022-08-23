CREATE SCHEMA IF NOT EXISTS comics;

SET search_path TO comics;

CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    character_name VARCHAR(128) NOT NULL,
    real_name VARCHAR(128),
    alignment VARCHAR(32) NOT NULL,
    publisher VARCHAR(64) NOT NULL,
    description TEXT,
    image_url TEXT,

    UNIQUE NULLS NOT DISTINCT (character_name, real_name)
);