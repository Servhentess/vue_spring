CREATE TABLE races (
  id          BIGSERIAL PRIMARY KEY,
  code        VARCHAR(50)  NOT NULL UNIQUE,
  libelle     VARCHAR(100) NOT NULL,
  description TEXT,
  caracs      JSONB        NOT NULL
);

CREATE TABLE classes (
  id          BIGSERIAL PRIMARY KEY,
  code        VARCHAR(50)  NOT NULL UNIQUE,
  libelle     VARCHAR(100) NOT NULL,
  description TEXT,
  caracs      JSONB        NOT NULL
);

CREATE INDEX idx_races_caracs_gin   ON races   USING GIN (caracs);
CREATE INDEX idx_classes_caracs_gin ON classes USING GIN (caracs);
