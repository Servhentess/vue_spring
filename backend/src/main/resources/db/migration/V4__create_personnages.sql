-- Crée la table des personnages avec références vers races et classes
CREATE TABLE IF NOT EXISTS personnages (
  id           BIGSERIAL PRIMARY KEY,
  code         VARCHAR(60)  NOT NULL UNIQUE,
  nom          VARCHAR(120) NOT NULL,
  niveau       INT          NOT NULL DEFAULT 1,
  race_id      BIGINT       NOT NULL,
  classe_id    BIGINT       NOT NULL,
  caracs       JSONB        NOT NULL,
  created_at   TIMESTAMP    NOT NULL DEFAULT NOW(),
  CONSTRAINT fk_personnages_race   FOREIGN KEY (race_id)   REFERENCES races(id),
  CONSTRAINT fk_personnages_classe FOREIGN KEY (classe_id) REFERENCES classes(id)
);

CREATE INDEX IF NOT EXISTS idx_personnages_code ON personnages(code);
