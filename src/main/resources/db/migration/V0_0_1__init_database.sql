CREATE SCHEMA IF NOT EXISTS comics;

SET search_path TO comics;

CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    character_name TEXT NOT NULL,
    real_name TEXT,
    alignment TEXT NOT NULL,
    publisher TEXT NOT NULL,
    description TEXT,
    image_url TEXT,

    UNIQUE NULLS NOT DISTINCT (character_name, real_name)
);