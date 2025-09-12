CREATE TABLE IF NOT EXISTS races (
  id          BIGSERIAL PRIMARY KEY,
  code        VARCHAR(50)  NOT NULL UNIQUE,
  libelle     VARCHAR(100) NOT NULL,
  description TEXT,
  caracs      JSONB        NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_races_code ON races(code);
