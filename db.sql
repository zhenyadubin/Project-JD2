CREATE SCHEMA information;

SET SEARCH_PATH = information;

-------------------------------------------------------------------------------------
CREATE TABLE stadium (
  id              SERIAL PRIMARY KEY,
  name            CHARACTER VARYING(256) UNIQUE NOT NULL,
  number_of_seats INTEGER                       NOT NULL,
  city_id         INTEGER REFERENCES city (id)
);
DROP TABLE stadium;

INSERT INTO stadium (name, number_of_seats, city_id) VALUES
  ('Трактор', 14000, 2);

SELECT
  id,
  name,
  number_of_seats,
  city_id
FROM stadium;

SELECT
  id,
  name,
  number_of_seats,
  city_id
FROM stadium
WHERE id = 1;
-----------------------------------------------------------------------------------------

CREATE TABLE country (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(256) UNIQUE NOT NULL
);

DROP TABLE country;

SELECT
  id,
  name
FROM country;
---------------------------------------------------------------------------------------------
CREATE TABLE city (
  id         SERIAL PRIMARY KEY,
  name       CHARACTER VARYING UNIQUE NOT NULL,
  country_id INTEGER REFERENCES country (id)
);

DROP TABLE city;

SELECT
  id,
  name,
  country_id
FROM city;
------------------------------------------------------------------------------------------------
CREATE TABLE league (
  id              SERIAL PRIMARY KEY,
  name            CHARACTER VARYING(256) UNIQUE   NOT NULL,
  country_id      INTEGER REFERENCES country (id) NOT NULL,
  number_of_clubs INTEGER                         NOT NULL
);
DROP TABLE league;
------------------------------------------------------------------------------------------------
CREATE TABLE coach (
  id         SERIAL PRIMARY KEY,
  first_name CHARACTER VARYING(256)          NOT NULL,
  last_name  CHARACTER VARYING(256)          NOT NULL,
  country_id INTEGER REFERENCES country (id) NOT NULL,
  birth_date DATE
);
DROP TABLE coach;
------------------------------------------------------------------------------------------------
CREATE TABLE football_club (
  id              SERIAL PRIMARY KEY,
  name            CHARACTER VARYING(256) UNIQUE   NOT NULL,
  stadium_id      INTEGER REFERENCES stadium (id) NOT NULL,
  foundation_date DATE,
  league_id       INTEGER REFERENCES league (id)  NOT NULL,
  coach_id        INTEGER REFERENCES coach (id)
);
DROP TABLE football_club;
--------------------------------------------------------------------------------------------------
CREATE TABLE player (
  id         SERIAL PRIMARY KEY,
  first_name CHARACTER VARYING(256)          NOT NULL,
  last_name  CHARACTER VARYING(256)          NOT NULL,
  country_id INTEGER REFERENCES country (id) NOT NULL,
  birth_date DATE,
  club_id    INTEGER REFERENCES football_club (id),
  number     INTEGER                         NOT NULL,
  position   CHARACTER VARYING(32)           NOT NULL
);
DROP TABLE player;
--------------------------------------------------------------------------------------------------
CREATE TABLE visitor (
  id           BIGSERIAL PRIMARY KEY,
  visitor_name CHARACTER VARYING(256) UNIQUE NOT NULL,
  e_mail       CHARACTER VARYING(256) UNIQUE NOT NULL,
  password     CHARACTER VARYING(256)        NOT NULL,
  role         CHARACTER VARYING(256)        NOT NULL
);
DROP TABLE visitor;
--------------------------------------------------------------------------------------------------
CREATE TABLE news (
  id        BIGSERIAL PRIMARY KEY,
  name      CHARACTER VARYING(256)          NOT NULL,
  text      CHARACTER VARYING               NOT NULL,
  author_id INTEGER REFERENCES visitor (id) NOT NULL,
  date      TIMESTAMP
);
DROP TABLE news;
-------------------------------------------------------------------------------------------------
CREATE TABLE visitor_comment (
  id            BIGSERIAL PRIMARY KEY,
  news_id       BIGINT REFERENCES news (id)    NOT NULL,
  visitor_id    BIGINT REFERENCES visitor (id) NOT NULL,
  text          CHARACTER VARYING              NOT NULL,
  date_and_time TIMESTAMP
);
DROP TABLE visitor_comment;
-------------------------------------------------------------------------------------------------
CREATE TABLE news_tag (
  news_id    BIGINT REFERENCES news (id)    NOT NULL,
  country_id INTEGER REFERENCES country (id),
  coach_id   INTEGER REFERENCES coach (id),
  league_id  INTEGER REFERENCES league (id),
  player_id  INTEGER REFERENCES player (id),
  club_id    INTEGER REFERENCES football_club (id),
  city_id    INTEGER REFERENCES city (id)
);
DROP TABLE news_tag;
---------------------------------------------------------------------------------------------------
CREATE TABLE visitor_tags (
  user_id    BIGINT REFERENCES visitor (id) NOT NULL,
  country_id INTEGER REFERENCES country (id),
  coach_id   INTEGER REFERENCES coach (id),
  league_id  INTEGER REFERENCES league (id),
  player_id  INTEGER REFERENCES player (id),
  club_id    INTEGER REFERENCES football_club (id),
  city_id    INTEGER REFERENCES city (id)
);
DROP TABLE visitor_tags;