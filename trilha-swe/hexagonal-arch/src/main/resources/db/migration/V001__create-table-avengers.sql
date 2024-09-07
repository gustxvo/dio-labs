CREATE TABLE avengers (
    avenger_id bigserial PRIMARY KEY,
    nick TEXT UNIQUE NOT NULL,
    person TEXT NOT NULL,
    description TEXT,
    history text
);
