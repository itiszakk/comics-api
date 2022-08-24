SET search_path TO comics;

INSERT INTO character VALUES
    (DEFAULT, 'Batman', 'Bruce Wayne', 'hero', 'dc', NULL, NULL),
    (DEFAULT, 'Catwoman', 'Selina Kyle', 'antihero', 'dc', NULL, NULL),
    (DEFAULT, 'Deathstroke', 'Slade Wilson', 'villain', 'dc', NULL, NULL),

    (DEFAULT, 'Spider-Man', 'Peter Parker', 'hero', 'marvel', NULL, NULL),
    (DEFAULT, 'The Punisher', 'Francis Castle', 'antihero', 'marvel', NULL, NULL),
    (DEFAULT, 'Carnage', 'Cletus Kasady', 'villain', 'marvel', NULL, NULL);