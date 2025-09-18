-- R__races_ajout.sql
-- Fichier repeatable réservé à l ajout de nouvelles races (vide pour l’instant)

INSERT INTO races (code, libelle, description, caracs) VALUES
 ('ORC','Orc','Puissant mais fruste','{"force":8,"dexterite":3,"intelligence":3,"vie":11}')
ON CONFLICT (code) DO UPDATE
  SET libelle=EXCLUDED.libelle,
      description=EXCLUDED.description,
      caracs=EXCLUDED.caracs;