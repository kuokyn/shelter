DROP TABLE IF EXISTS animal;

CREATE TABLE animal
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name TEXT
);

CREATE INDEX ON animal (name);